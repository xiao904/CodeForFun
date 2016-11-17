/**
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.


**/

//to Check if x contains y*y + z*z, 
//from 1~ y  y*y<=x
//check the min nums which sum to x;
//from 1 -- n;
//f(x) = Min(f(x - y*y) +1;)
public class Solution {
    public int numSquares(int n) {
        //from 1-y
        //f(x)= f(x-(y*y))+1
        int[] dp=new int[n+1];
        for(int i=1;i<=n;i++){
            dp[i]=Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                dp[i]=Math.min(dp[i],dp[i-(j*j)]+1);
            }
        }
        return dp[n];
    }
}