/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?


*/


//1.if two arrays are sorted, using two pointers, become easy. ( which would help skip sort steps ,and directly get into the two pointers to find intersection)

//2.if num1/s size is smaller than nums2 size. First, Hashmap solution is time of O(m) (n is the length of the array which was used to do the count, lets say first one: nums1, and m is the length of the other, which is longer) and space of O(3n) (since the first array us smaller) . and Sort and two pointers solution, are time of max(O(mlogm), O(m+n) ,O(nlogn) ) (as O(mlogm > nlogn since m>n)). and space of O(2n) (arraylist:O(n) and finally constructing the int array O(n) )

//3.if the longer array cannot be loaded into memory all at one time, it is easy to handle it by first solution, which is find the intersection of the first array with each chunk of the second array loaded into memory, then finally the intersection is still right

public class Solution {
    //Solution 2: sort + two pointers
	//time: Max(mlogm , nlogn , m+n)
	//extra space:O(1)
    public int[] intersect(int[] nums1, int[] nums2) {
        //sort nums1 nums2
        //two pointers
        if(nums1 == null || nums2 == null) return null;
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        int i = 0 , j = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                res.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
                i++;
            }
        }
        int[] resArray = new int[res.size()];
        for(int m = 0; m < res.size(); m++){
            resArray[m] = res.get(m);
        }
        return resArray;
    }
	
	//Solution 1: HashTable to store the (m/n) values and counts, and then compare with the other one
    //time: O(m/n)
    //Space:O(n/m)
    public int[] intersect(int[] nums1, int[] nums2){
        if(nums1 == null || nums2 == null) return null;
		List<Integer> res = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums1){
            map.put(i, map.getOrDefault(i, 0) + 1);
		}		
		for(int j : nums2){
		    if(map.containsKey(j)){
			   res.add(j);
			   map.put(j, map.get(j) - 1);
			   if(map.get(j) == 0) map.remove(j);
			}
		}
		int[] resArray = new int[res.size()];
		for(int i = 0; i < res.size(); i++){
		    resArray[i] = res.get(i);
		}
		return resArray;
	}	
}