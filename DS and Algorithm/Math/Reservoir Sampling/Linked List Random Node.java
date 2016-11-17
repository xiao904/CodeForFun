/*
Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

Example:

// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();


*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 /*��ǰ����˵������������������ȴ���򵥵����ӳ�����������ֻ��һ�����ݡ����ǽ������ݣ����������������ˣ�ֱ�ӷ��ظ����ݣ������ݷ��صĸ���Ϊ1�������ܼ򵥣���ô����������һ�����������������������������ݡ�

���Ƕ����˵�һ�����ݣ�������ǲ���ֱ�ӷ��ظ����ݣ���Ϊ������û�н��������Ǽ�����ȡ�ڶ������ݣ����������������ˡ��������ֻҪ��֤����ͬ�ĸ��ʷ��ص�һ�����ߵڶ������ݾͿ���������ĿҪ�������������һ��0��1�������R,���RС��0.5���Ǿͷ��ص�һ�����ݣ����R����0.5�����صڶ������ݡ�

�������Ǽ����������������ݵ��������������Ϊ�˷��㣬���ǰ�˳������е���������Ϊ1��2��3������½���յ�������1��2��ǰ�������һ��������ֻ�ܱ���һ�����ݣ����Ա�����̭1��2�е�һ����Ӧ�������̭�أ���������������һ�������ǰ��ն���֮һ�ĸ�����̭һ��������������̭��2��������ȡ���е�����3�����������������ˣ�����֪���ڳ���Ϊ3���������У������������3�ĸ���Ϊ1/3,��ô���п��ܱ�֤ѡ�����ȷ�ԡ�Ҳ����˵��Ŀǰ����������1,3�������ݣ�����ͨ��һ�����ѡ����1/3�ĸ�����������3����2/3�ĸ�����������1.��ô����1���������µĸ����Ƕ����أ�

����1�����£���1/2��*(2/3) = 1/3
����2�����¸��ʣ���1/2��*(2/3) = 1/3
����3�����¸��ʣ�1/3
�����������������ĿҪ���������ݱ����·��صĸ���һ����

��ˣ�������һ�����ۣ����赱ǰ��Ҫ��ȡ��n�����ݣ���������1/n�ĸ������¸����ݣ���������ǰn-1�������е�һ���������ַ���ѡ�����������������ݱ�ѡ��ĸ���һ������̵�֤��������n-1ʱ���������ǰn-1�����ݱ����صĸ��ʶ���1/n-1,��ǰ���ڶ�ȡ��n�����ݣ���1/n�ĸ��ʷ���������ôǰn-1�����������ݱ����صĸ���Ϊ��(1/(n-1))*((n-1)/n)= 1/n�����������

�������ν����ˮ�س����㷨�����ڷ���һЩ�����ݼ���ʱ��ǳ����á�������������ҵ�Gregд�Ĺ�����ˮ�س������㷨���ܡ�*/
 
public class Solution {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    private Random random;    
    private ListNode head;
        
    public Solution(ListNode head) {
        random = new Random();
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode cur = this.head;
        int res = 0;
        for(int i = 0; cur != null; i++){
            if(random.nextInt(i+1) == i) res = cur.val;
            cur = cur.next;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */