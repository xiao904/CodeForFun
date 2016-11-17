/**Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
           /*
		   use the fast and slow pointer to determine the mid point
		   reverse the first half
		   compare the first half to the second half
		   */
		   ListNode fast = head, slow = head, newHead = null;
		   while(fast != null && fast.next != null){
		        fast = fast.next.next;
				ListNode next = slow.next;
				slow.next = newHead;
				newHead = slow;
				slow = next;
		   }
		   if(fast != null){
		     //the number of nodes are odd
			 while(slow.next != null && newHead != null && slow.next.val == newHead.val){
			     slow = slow.next;
				 newHead = newHead.next;
			 }
		   }else{
		     //the number of nodes are even
		       while(slow != null && newHead != null && slow.val == newHead.val){
			     slow = slow.next;
				 newHead = newHead.next;
			 }
		   }
		   return newHead == null;
    }
    
   
}