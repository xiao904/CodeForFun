/*Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;
		while(cur.next != null){
		     if(cur.next.val == val){
			     cur.next = cur.next.next;
			 }else{
			     cur = cur.next;
			 }
		}
		return dummy.next;
    }
	
	//recursive
	//Recursion with three base case:

    //head is NULL
    //head->val = val
    //Other cases
	public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
		else if(head.val == val){
		    return removeElements(head.next, val);
		}else{
		    head.next = removeElements(head.next, val);
			return head;
		}
    }
    
}