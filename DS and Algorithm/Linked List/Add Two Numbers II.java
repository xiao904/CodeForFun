/*You are given two linked lists representing two non-negative numbers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
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
        //if input invalid what should I do
        //stack to push every node and pop out the last;
        Stack<Integer> c1 = new Stack<>();
        Stack<Integer> c2 = new Stack<>();
        while(l1 != null){
            c1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            c2.push(l2.val);
            l2 = l2.next;
        }
        int sum = 0; 
        ListNode tail = new ListNode(0);
        while(!c1.isEmpty() || !c2.isEmpty()){
            if(!c1.isEmpty()) sum += c1.pop();
            if(!c2.isEmpty()) sum += c2.pop();
            tail.val = sum%10;
            ListNode tmp = new ListNode(sum/10);
            tmp.next = tail;
            tail = tmp;
            sum = sum/10;
        }
        return tail.val == 0 ? tail.next : tail;
    }
	
}