/*
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?

Subscribe to see which companies asked this question

*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
          if(head == null || head.next == null) return false;
          ListNode fast = head, slow = head;
          while(fast != null && fast.next != null){
              
              fast = fast.next.next;
              slow = slow.next;
              if(fast == slow) return true;
          }
          return false;
    }
	
	//follow up find the entry point of the cycle
	public ListNode entryCycle(ListNode head) {
          
          ListNode fast = head, slow = head;
          while(fast != null && fast.next != null){
              fast = fast.next.next;
              slow = slow.next;
			  if(fast == slow) break;
          }
		  if(head == null || head.next == null) return null;
		  //when enter into the cycle, fast is k nodes ahead slow, in order to make them encounter/ k is the entrypoint
		  //fast must run r-k nodes more than slow/ fast-slow = r - k fast = 2slow r is the circle length;
		  
 		  //slow at (r-k) th node from the start, k nodes left to the end of the cycle		  
		  fast = head;
		  while(fast != slow){
		     fast = fast.next;
			 slow = slow.next;
		  }
          return slow;
    }
	
	
}
