/**

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: 
You may assume k is always valid, ie: 1 �� k �� input array's size for non-empty array.

Follow up:
Could you solve it in linear time?

Hint:

How about using a data structure such as deque (double-ended queue)?
The queue size need not be the same as the window��s size.
Remove redundant elements and the queue should store only elements that need to be considered.
 */
 
 
/*Sliding Window Maximum
�����ص㣺
ֻ���������ڵ� max;
ֻҪͬһ������ max һ���������һ����������Ԫ�صĳ���
˳����������б��� max/min stack �ı���Ԫ��˳��Ҫ
��
���Ⱪ��ѭ������ O(nk)��hasheap ���� O(n log k)��deque ���� O(n).
����ÿһ��Ҫִ����������������
��ӵ�ǰԪ�� nums[i];
ɾ��ָ��Ԫ�� nums[i - k];
�ҵ���ǰ window max;
�����ⷨ�У����ǿ���ֱ��ά��һ�� list��ÿ�β���������ɨ�裬�����ĸ��Ӷ�
�ǣ�
Add O(1)
Remove O(k)
max O(k)
��һ��ѡ���ǣ�ά��һ�� sorted list�������ĸ��Ӷ��ǣ�
Add O(k)
Remove O(k)
max O(1)
�ٹ۲���Ŀ���Կ��Է��֣�������ά�� sorted list ���кܶ����ȡ�ɵĵط���
��Ϊ����ֻ����ÿ�� window �ϵ� max�����û�б�Ҫ�� window �ڵ�����Ԫ
�ض����ţ��� Add ��ʱ�����ֱ�Ӱ�С����Ԫ�ص�ֵ�� pop ����
���� remove �ϣ������ս�������Ӱ��ģ�ֻ������ remove ��Ԫ�ؾ���
max �����Σ���Ϊ�����޹�Ԫ���� add ��ʱ��ͱ��õ��ˣ�������ǿ��Դ�һ
��Ԫ�ص����λ�ã��Դ����ж�����Ҫɾ����Ԫ���ǲ��ǵ�ǰ�� max.
��Ϊ����ά������ sorted array ��max ��Ȼ�� O(1).
����ÿһ��Ԫ��ֻ�ᱻ add �� remove һ�Σ��������̵ľ�̯���ӶȾ���
O(1).
Ҫ�㣺
ά��һ������˫������� sorted array.
Deque ����Ҫ�� index��������ֵ����Ȼ����� [8,1,2,8...]
��������£������п��ܻ�Ѹռӽ�ȥ�� 8 �ָ��ó�����
bug.*/
public class Solution {
    /*
	1. max heap(every time to refresh the queue)--O((n-k)(lgk+k)) = O((n-k)k)
	2. max heap with index in it O(n-k)logk
	3. doubly linkedlist to restore the max O(n)
	*/
	
	//Solution 3
    public int[] maxSlidingWindow(int[] nums, int k) {
        //doubly linked list store the index have max values from i ~ i-k;
        // max at the first;
        //remove the element outbounded
        //if lastNode <= nums[i] remove the last one
        //add num[i];
        //Deque Method: use deque to record the index, remove elements out of window in the head, and remove the smaller elements in the tail which have no change to become max.
        if(nums == null || nums.length < k) throw new Exception("invalid input");
		int[] res = new int[nums.length - k + 1];
		LinkedList<Integer> maxHeap = new LinkedList<Integer>();
        for(int i = 0; i < nums.length; i++){
		    int index = i-k+1;
		    while(!maxHeap.isEmpty() && maxHeap.peek() < index) maxHeap.poll();
			while(!maxHeap.isEmpty() && nums[maxHeap.peekLast()] <= nums[i]) maxHeap.pollLast();
            maxHeap.offer(i);
            if(index >= 0) res[index] = maxHeap.peek(); 			
		}
		return res;
    }
	
	//Solution 1
	public int[] maxSlidingWindow(int[] nums, int k) {
	
	      if(nums == null || nums.length < k) throw new Exception("invalid input");
		  PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		  for(int i = 0; i < k; i++){
		     heap.offer(nums[i]);
		  }
		  int[] res = new int[nums.length - k + 1];
		  for(int j = 0; j < res.length; j++){
		    res[j] = heap.peek();
			heap.remove(nums[j]);
			if(j+k < nums.length){
			   heap.offer(nums[j+k]);
		    }
		  }
		  return res;
	
	
	}
}