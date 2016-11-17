/*Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]*/
public class Solution {
    //time complexity n^2
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> totalres = new ArrayList<>();
        if(nums == null || nums.length < 3) return totalres;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
          if(i==0 || (i > 0 && nums[i] != nums[i-1])){ 
            int start = i + 1, end = nums.length -1;
            while(start < end){
             
               if(nums[start] + nums[end] > 0-nums[i]){
                 end--;
               }else if(nums[start] + nums[end] < 0-nums[i]){
                 start++;
               }else{
                
                 totalres.add(Arrays.asList(nums[i], nums[start], nums[end]));
                 while(start < end && nums[start+1] == nums[start])
                      start++;
                 while(start < end && nums[end-1] == nums[end])
                      end--;
                 start++;
                 end--;
               }
            }
              
          }
        }
        return totalres;
    }

    public int threeSumClosest(int[] nums, int target) {
        //sort nums
        //Math.abs min
        //two pointers
		//time complexity n^2
        if(nums == null || nums.length < 3)
            return 0;
        Integer res = null;
        Arrays.sort(nums);
        for(int i  = 0; i < nums.length-2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int start = i+1;
            int end = nums.length-1;
            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if(sum > target){
                    end--;
                }else if(sum < target){
                    start++;
                }else{
                    return target;
                }
                if(res == null || Math.abs(sum - target) < Math.abs(res - target)){
                    res = sum;
                }
            }
         }
         return (int)res;
    }
}