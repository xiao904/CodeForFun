/*
Given a non-negative number represented as a singly linked list of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

Example:

Input:
1->2->3

Output:
1->2->4
*/

public class Solution{

    public ListNode plusOne(ListNode head) {
         if(head == null) return head;
		 if(helper(head) == 1){
		    ListNode top = new ListNode(1);
            top.next = head;
            return top;			
		 }
		 return head;
	}
	
	public int helper(ListNode head){
	    if(head == null) return 1;
		int carry = helper(head.next);
	    int sum = head.val + carry;
		head.val = sum%10;
        return sum/10;		
	}
	
	//find the last number is not 9
	//then change all numbers after that 9 to 0;
	//if there is no such number, add a 1 node , link to head, and  change all to 0
	public ListNode plusOne(ListNode head) {
         if(head == null) return head;
		 ListNode cur = head;
		 ListNode lastNot9 = null;
		 while(cur != null){
		    if(cur.val != 9) lastNot9 = cur;
			cur = cur.next;
		 }
		 if(lastNot9 == null){
		     lastNot9 = new ListNode(0);
			 lastNot9.next = head;
			 head = lastNot9;
		 }
		 lastNot9.val = lastNot9.val + 1;
		 cur = lastNot9.next;
		 while(cur != null){
			    cur.val = 0;
				cur = cur.next;
		}
		return head;
		 
	}
	
	
	

}