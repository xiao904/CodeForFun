/*Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

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
    public ListNode rotateRight(ListNode head, int k) {
        //if k > len
        //k = k%len;
        if(head == null || head.next == null) return head;
        ListNode cur = head;
        int len = 1;
        while(cur.next!=null){
            cur = cur.next;
            len++;
        }
        k = len - k%len;
        cur.next = head;
        while(k > 0){
            cur = cur.next;
            k--;
        }
        head = cur.next;
        cur.next = null;
        return head;
    }
}