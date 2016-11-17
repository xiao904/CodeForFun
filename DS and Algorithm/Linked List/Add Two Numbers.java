/*You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

Subscribe to see which companies asked this question*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return l1 == null ? l2 : l1;
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		int carry = 0;
		while(l1 != null || l2 != null){
		     int val1 = l1 == null ? 0 : l1.val;
			 int val2 = l2 == null ? 0 : l2.val;
			 int sum = val1 + val2 + carry;
			 carry = sum / 10;
			 ListNode tmp = new ListNode(sum%10);
			 cur.next = tmp;
			 cur = cur.next;
			 l1 = l1.next;
			 l2 = l2.next;
        }
		if(carry != 0){
		    ListNode tmp = new ListNode(carry);
			cur.next = tmp;
		}
		return dummy.next;
    }
}