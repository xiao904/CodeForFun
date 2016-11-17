/**
Given an array of integers where 1 ¡Ü a[i] ¡Ü n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
**/

public class Solution{
   public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
		for(int i = 0; i < nums.length; i++){
		   //Link the value to index
		   int index = Math.abs(nums[i])-1;
		   //all occurred numbers marked negative
		   if(nums[index] > 0)
		      nums[index] = -nums[index];
		}
		for(int j = 0; j < nums.length; j++){
		     if(nums[j] > 0)
			   res.add(j+1);
		}
		return res;
   
   }
}