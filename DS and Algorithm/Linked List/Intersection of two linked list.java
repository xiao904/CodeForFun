/*
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 ¡ú a2
                   ¨K
                     c1 ¡ú c2 ¡ú c3
                   ¨J            
B:     b1 ¡ú b2 ¡ú b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution{


    //?headA == null headB == null return?
    //link headA to headB
    //link headB to headA
    //they encounter at intersection
     public ListNode findIntersection(ListNode nodeA, ListNode nodeB){
	       if(nodeA == null || nodeB == null) return null;
		   while(nodeA != nodeB){
		      if(nodeA != null){
	             nodeA = nodeA.next;		  
			  }else{
			     nodeA = nodeB;
			  }
			  if(nodeB != null){
	             nodeB = nodeB.next;		  
			  }else{
			     nodeB = nodeA;
			  }
		   }
		   return nodeA;
	     
	 
	 
	 }



}