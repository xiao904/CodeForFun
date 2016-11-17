/**Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.**/


public class Solution{
    //all characters  more than once even numbers 
	//use a array to store how many time a char appear
	//count the even number//
	//see if there's an extra char
	public int longestPalindrome(String s) {
	      int[] arr=new int['z'-'A'+1];
		  char[] chars=s.toCharArray();
		  int maxLength=0;
		  for(Character c:chars){
		     arr[c-'A']++;
		  }
	      for(int n:arr) maxLength+=n/2*2;
		  return Math.min(maxLength+1,s.length());
	
	}


}