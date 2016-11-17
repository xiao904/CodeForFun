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
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?

Hint:

How about using a data structure such as deque (double-ended queue)?
The queue size need not be the same as the window’s size.
Remove redundant elements and the queue should store only elements that need to be considered.
 */
 
 
/*Sliding Window Maximum
操作特点：
只关心区域内的 max;
只要同一区域内 max 一样，输出就一样，不在意元素的出现
顺序，因此这题有别于 max/min stack 的保存元素顺序要
求。
这题暴力循环可以 O(nk)，hasheap 可以 O(n log k)，deque 可以 O(n).
我们每一步要执行下面三个操作：
添加当前元素 nums[i];
删除指定元素 nums[i - k];
找到当前 window max;
暴力解法中，我们可以直接维护一个 list，每次操作都进行扫描，这样的复杂度
是：
Add O(1)
Remove O(k)
max O(k)
另一种选择是，维护一个 sorted list，这样的复杂度是：
Add O(k)
Remove O(k)
max O(1)
再观察题目特性可以发现，我们在维护 sorted list 上有很多可以取巧的地方：
因为我们只关心每个 window 上的 max，因此没有必要把 window 内的所有元
素都留着，在 Add 的时候可以直接把小于新元素的值都 pop 掉；
而在 remove 上，对最终结果会产生影响的，只有我们 remove 的元素就是
max 的情形，因为其他无关元素在 add 的时候就被拿掉了；因此我们可以存一
个元素的相对位置，以此来判断我们要删掉的元素是不是当前的 max.
因为我们维护的是 sorted array ，max 依然是 O(1).
由于每一个元素只会被 add 和 remove 一次，整个流程的均摊复杂度就是
O(1).
要点：
维护一个可以双向操作的 sorted array.
Deque 里面要存 index，而不是值，不然会出现 [8,1,2,8...]
这种情况下，我们有可能会把刚加进去的 8 又给拿出来的
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