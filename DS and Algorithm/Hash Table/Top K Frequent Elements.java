/*
Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ¡Ü k ¡Ü number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/


public class Solution {
    //Solution 1 Heap nlog(k)
    public List<Integer> topKFrequent(int[] nums, int k) {
	      
          List<Integer>	res = new LinkedList<>();
		  if(nums == null || nums.length < k) return res;
          Map<Integer,Integer> freq = new HashMap<>();
		  for(int i : nums){
              freq.put(i, freq.getOrDefault(i, 0) + 1);
		  }
          PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>((a,b)-> a.getValue() - b.getValue());
          for(Map.Entry<Integer, Integer> m : freq.entrySet()){
		     if(queue.size() < k){
			       queue.offer(m);
			 }else if(!queue.isEmpty() && queue.peek().getValue() < m.getValue()){
			       queue.poll();
				   queue.offer(m);
			 }
		  }
          while(!queue.isEmpty()){
              ((LinkedList)res).addFirst(queue.poll().getKey());
		  }
          return res;		  
     	
	}
	
	//Solution 2 Bucket Sort O(n)
	 public List<Integer> topKFrequent(int[] nums, int k) {
	      List<Integer>	res = new LinkedList<>();
		  if(nums == null || nums.length < k) return res;
          Map<Integer,Integer> freq = new HashMap<>();
		  int max = 0;
		  for(int i : nums){
              freq.put(i, freq.getOrDefault(i, 0) + 1);
			  max = Math.max(max, freq.get(i));
		  }
		  List<Integer>[] bucket = new ArrayList[max+1];
		  for(Map.Entry<Integer, Integer> m : freq.entrySet()){
		      if(bucket[m.getValue()] == null){
			      bucket[m.getValue()] = new ArrayList<Integer>();
			  }
			  bucket[m.getValue()].add(m.getKey());
		  }
		  for(int i = max; i > 0 && k > 0; i--){
		     if(bucket[i] != null){
		          res.addAll(bucket[i]);
			      k -= bucket[i].size();
		      }
		  }
		  return res;
     	
	}
}