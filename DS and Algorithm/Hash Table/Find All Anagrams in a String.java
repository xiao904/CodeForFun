/*
438. Find All Anagrams in a String   QuestionEditorial Solution  My Submissions
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
Subscribe to see which companies asked this question



*/

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
       //substring contains all character of p
       //initial a map of Character s
       //check the i ~ i - p.length();
       //update the map when add one or remove one
	   //a~z map with size of 26 
	   List<Integer> res = new ArrayList<>();
	   if(s == null || p == null || s.length() < p.length()) return res;
	   int[] map = new int[26];
	   //build the map
	   for(char c : p.toCharArray()){
	      map[c - 'a']++;
	   }
	   int count = p.length();
	   for(int i = 0, j = 0; i < s.length(); i++){
	       if(map[s.charAt(i)] > 0) count--;
		   map[s.charAt(i)]--;
		   if(count == 0) res.add(j);
		   //if i - j == the p's length move left node by 1
           // and update the count and map
		   if( i - j + 1 == p.length()) { 
		       if(map[s.charAt(j)] >= 0) count++;
			   map[s.charAt(j)]++;
			   j++;
		   }
	      
	   }
       return res;
    }
}