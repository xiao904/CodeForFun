/*Given a singly linked list L: L0¡úL1¡ú¡­¡úLn-1¡úLn,
reorder it to: L0¡úLn¡úL1¡úLn-1¡úL2¡úLn-2¡ú¡­

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    //find mid point 
    //reverse the last half
    //merge two half
    public void reorderList(ListNode head) {
	   if(head == null) return;
	   ListNode fast = head;
	   ListNode slow = head;
	   while(fast != null && fast.next != null){
	       fast = fast.next.next;
	       slow = slow.next;
	   }
	   //slow - the mid point
	   ListNode secHalf = reverse(slow.next);
	   slow.next = null;
	   while(secHalf!=null){
	       ListNode hnext = head.next;
		   ListNode snext = secHalf.next;
		   head.next = secHalf;
		   secHalf.next = hnext;
		   secHalf = snext;
		   head = hnext;
	   }
	}
	
	public ListNode reverse(ListNode node){
	    ListNode tailTohead = null;
		while(node != null){
		    ListNode next = node.next;
			node.next = tailTohead;
			tailToHead = node;
			node = next;
		}
		return tailTohead;
	}
}