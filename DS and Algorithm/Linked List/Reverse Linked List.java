/*Reverse a singly linked list.

click to show more hints.

Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    //iteratively
    public ListNode reverseList(ListNode head) {
        ListNode tail = null;
        while(head != null){
            ListNode next = head.next;
            head.next = tail;
            tail = head;
            head = next;
        }
        return tail;
    }
	
	//recursively
	public ListNode reverseList(ListNode head){
	    if(head == null || head.next == null) return head;
		ListNode reversehead = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return reversehead;
	
	}
    
}