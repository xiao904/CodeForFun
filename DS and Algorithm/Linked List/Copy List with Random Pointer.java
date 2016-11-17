/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

Subscribe to see which companies asked this question

*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
	     //Hashtable to record all copy node
		 if(head == null) return null;
		 Map<RandomListNode, RandomListNode> map = new HashMap<>();
		 RandomListNode copyhead = new RandomListNode(head.label);
		 map.put(head, copyhead);
		 RandomListNode cur = head;
		 RandomListNode copycur = copyhead;
		 while(cur != null && cur.next != null){
		     map.putIfAbsent(cur.next, new RandomListNode(cur.next.label));
			 copycur.next = map.get(cur.next);
			 cur = cur.next;
			 copycur = copycur.next;
		 }
		 cur = head;
		 copycur = copyhead;
		 while(cur != null){
		    if(cur.random != null) {
			  map.putIfAbsent(cur.random, new RandomListNode(cur.random.label));
			  copycur.random = map.get(cur.random);
			}
			cur = cur.next;
			copycur = copycur.next; 
		 }
		 return copyhead;
	}
	
}	