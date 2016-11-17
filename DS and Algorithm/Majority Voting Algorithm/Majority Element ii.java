/*
Given an integer array of size n, find all elements that appear more than ? n/3 ? times. The algorithm should run in linear time and in O(1) space.

Hint:

How many majority elements could it possibly have?
Do you have a better hint? Suggest it!
Subscribe to see which companies asked this question

*/

public class Solution {
//Voting algorithm
// keep count the element from first one, if not the cur one, count--,
//count=0 recalculate a new one
    public List<Integer> majorityElement(int[] nums) {
       List<Integer> res = new ArrayList<>();
       if(nums.length == 0) return res;
       int c1=nums[0], c2= nums[0], count1 = 1, count2 = 0;
       for(int i = 1; i < nums.length; i++){
          if(nums[i] == c1){
             count1++;
          }else if(nums[i] == c2){
             count2++;
          }else if(count1 == 0){
             c1 = nums[i]; 
             count1++;
          }else if(count2 == 0){
             c2 = nums[i];
             count2++;
          }else{
             count1--;
             count2--;
          }  
       } 
       //do the traversal again
       count1 = 0;
       count2 = 0;
       for(int j = 0; j < nums.length; j++){
          if(nums[j] == c1) count1++;
          else if(nums[j] == c2) count2++;
       }
       if(count1 > nums.length/3){
          res.add(c1);
       } 
       if(count2 > nums.length/3){
          res.add(c2);
       }
       return res;
    }
}