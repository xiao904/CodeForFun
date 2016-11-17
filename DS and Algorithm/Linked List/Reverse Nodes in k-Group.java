/*Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    ///////////
	///head = pre.next;
	///ListNode next = head.next;
	///head.next = next.next;
	///next.next = pre.next;
	///pre.next = next;
	///get tail node
	///////////
	          /*ListNode* temp = pre -> next;
                pre -> next = cur -> next;
                cur -> next = cur -> next -> next;
                pre -> next -> next = temp;
				get tail node;
				*/ 
				
				/* ListNode tail;
				ListNode next = head.next;
				head.next = tail;
                tail = head;				
				head = next;
				get head && tail+1 node*/
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        int count  = 1;
        while(cur != null){
            if(count == k){
                ListNode node = pre.next;
                while(count > 1){
                    ListNode next = node.next;
                    node.next = next.next;
                    next.next = pre.next;
                    pre.next = next;
                    count--;
                }
                pre = node;
                cur = node.next;
            }else{
                cur = cur.next;
                count++;
            } 
        }
        return dummy.next;
        
    }
	
	public ListNode reverseKGroup(ListNode head, int k) {
       if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        int count  = 1;
        while(hasKNodes(cur, k)){
           for(int i = 0; i < k - 1; i++){
               ListNode next = cur.next;
               cur.next = next.next;
               next.next = pre.next;
               pre.next = next;
           }
           pre = cur;
           cur = pre.next;    
        }
        return dummy.next;
        
    }
    
    boolean hasKNodes(ListNode node, int k){
        int i = 0;
        while(node != null){
            i++;
            node = node.next;
            if(i == k) return true;
        }
        return false;
    }
	
	
	//recrusive
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
		int i = 0;
		ListNode cur = head;
        while(cur != null && i < k){
		     cur = cur.next;
			 i++;
		}
		if(i == k){
	      ListNode nexthead = reverseKGroup(cur, k);
		  while(i > 0){
		      ListNode next = head.next;
		      head.next = nexthead;
		      nexthead = head;
	          head = next;
			  i--;
		  }
		  return nexthead; 
		}
        return head;
        
    }
}