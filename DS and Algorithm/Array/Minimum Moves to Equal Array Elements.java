/*Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

Example:

Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]*/


public class Solution{

    public int minMoves(int[] nums) {
        /*  .
           ..    
          ...      
                ..
               ...    
               ...
        */
        //increment n -1 element by one = substract 1 element by one remove the last line like russian
        //find min
        //res = each element - min
        int min = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < min){
                min = nums[i];
            }
        }
        int res = 0;
        for(int j : nums){
            res += j - min;
        }
        return res;
    }


}
