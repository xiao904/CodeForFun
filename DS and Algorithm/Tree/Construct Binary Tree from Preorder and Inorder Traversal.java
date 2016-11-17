/*Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 

public class Solution {
    //find the root in preorder 1st one
	//find the root in inorder mid one
	//build the left half from inorder - left tree
	//build the right half from inorder- right tree
	//recursive
    public TreeNode buildTree(int[] preorder, int[] inorder) {
	      build(0, 0, inorder.length-1, preorder, inorder);
	}
	
	public TreeNode build(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder){
	    TreeNode root = new TreeNode(preorder[preStart]);
		int mid = 0;
		for(int i = inStart; i <= inEnd; i++){
		    if(inorder[i] == preorder[preStart]){
			   mid = i;
			}
		}
		root.left = build(preStart+1, inStart, mid-1, preorder, inorder);
	    root.right = build(preStart+1+(mid-inStart) , mid+1, inEnd, preorder, inorder);
		return root;
	}
	
	
	public TreeNode buildTreeIterative(int[] preorder, int[] inorder){
	      //build the tree mainly based on preorder, inorder to find the mid root
	
	      if(preorder.length == 0 || inorder.length == 0) return null;
	      Stack<TreeNode> stack = new Stack();
		  TreeNode root = new TreeNode(preorder[0]);
		  TreeNode cur = root;
		  //deep traverse the left node
		  for(int i = 1, j = 0; i < preorder.length; i++){
		     //check the node if it has left node
		     if(cur.val != inorder[j]){
			    cur.left = new TreeNode(preorder[i]);
			    stack.push(cur);
				cur = cur.left;
		     }else{
			    //traverse back to the nearest node has right node
				j++;
				while(!stack.isEmpty() && stack.peek() == inorder[j++]){
				   cur = stack.pop();
				}
				//add right node from preorder
				cur.right = new TreeNode(preorder[i]);
				cur = cur.right;
			 }
		  }
		  return root;
		  
	
	}
}