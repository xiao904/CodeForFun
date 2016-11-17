/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/

public class Solution {
    //count the zero numbers---n
	//to move each element which is not 0 forward by n
    public void moveZeroes(int[] nums) {
       int zeroCount=0;
       for(int i=0;i<nums.length;i++){
           int val=nums[i];
           if(val==0){
               zeroCount++;
           }else if(zeroCount>0){
               nums[i-zeroCount]=nums[i];
               nums[i]=0;
           }
       }
        
        
    }
    
    
}