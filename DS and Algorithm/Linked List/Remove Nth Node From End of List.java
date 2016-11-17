/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.

Subscribe to see which companies asked this question
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //two pointers fast slow
        // fast forward n steps first
        //then fast slow to forward to the end
        //then slow == the nth from end
        ListNode fast = head, slow = head;
        for(int i = 0; i < n; i++){
            if(fast == null) return head;
            fast = fast.next;
        }
        //corner case if remove head node;
        if(fast == null) return head.next;
        while(fast.next!= null){
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        return head;
    }
}