/*
Given inorder and postorder traversal of a tree, construct the binary tree.
*/

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
    //find root in postorder
    //find root in inorder
    //root.left= left half in inorder
    //left half in inorder find root in postorder 
    //root.right= right half in order
    //right half in order find root in postorder 
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder.length-1,0,inorder.length-1,inorder,postorder);
    }
    
    
    public TreeNode build(int pRoot,int inStart,int inEnd,int[] inorder,int[] postorder){
        if(pRoot<0||inStart>inEnd) return null;
        int rootVal=postorder[pRoot];
        int startindex=0;
        for(int i=inStart;i<=inEnd;i++){
            if(inorder[i]==rootVal){
                startindex=i;
            }
        }
        TreeNode root=new TreeNode(rootVal);
        //left root point  would be the current root position - the length of the right half
        root.left=build(pRoot-(inEnd-startindex)-1,inStart,startindex-1,inorder,postorder);
        root.right=build(pRoot-1,startindex+1,inEnd,inorder,postorder);
        return root;
    }
}