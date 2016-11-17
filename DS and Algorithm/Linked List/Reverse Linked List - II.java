/*Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ¡Ü m ¡Ü n ¡Ü length of list.

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

     public ListNode reverseBetween(ListNode head, int m, int n) {
        //get the head before mth node
        //get the tail after nth node
        //link these two node
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy, pre = null;
        int i  = 0;
        while(i < m){
            i++;
            if(i == m) pre = cur; 
            cur = cur.next;
        }
        while(i < n){
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
            i++;
        }
        return dummy.next;
    }
    
}