/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
Subscribe to see which companies asked this question

Show Tags
Show Similar Problems
*/
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //store the num in nums2
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums2.length; i++){
            set.add(nums2[i]);
        }
        Set<Integer> res = new HashSet<>();
        for(int j = 0; j < nums1.length; j++){
            if(set.contains(nums1[j])){
                res.add(nums1[j]);
            }
        }
        int[] resArray = new int[res.size()];
        int m = 0;
        for(int n : res){
            resArray[m++] = n;
        }
        return resArray;
    }
	
	//sorted array,
	//doing binary search.
	//sort nums1
    // L1< L2
    //if l1 > l2  reverse	
	//O = mlog(n) n>m;
	public int[] intersection(int[] nums1, int[] nums2) {
        //sort nums2
        //binarySearch nums1 in nums2
		if(nums1 == null || nums2 == null) throw new Error();
        Arrays.sort(nums2);
        Set<Integer> res = new HashSet<>();
        for(int i : nums1){
            if(binarySearch(nums2, i)){
                res.add(i);
            }
        }
        int[] resArray = new int[res.size()];
        int n = 0;
        for(int j : res){
            resArray[n++] = j;
        }
        return resArray;
    }
    
    boolean binarySearch(int[] nums, int val){
        int left = 0;
        int right = nums.length -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] > val){
                right = mid - 1;
            }else if(nums[mid] < val){
                left = mid + 1;
            }else{
                return true;
            }
        }
        return false;  
    }
	
}