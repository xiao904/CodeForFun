
/**Word Pattern  
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
**/

public class Solution {

    //??pattern==null str == null
	//??length
    public boolean wordPattern(String pattern, String str) {
        //build a map store str-char pair;
        //check if map.get(key) == pattern.charAt(i);
        if(pattern == null && str == null) return true;
		else if(pattern == null || str == null) return false;
        Map<String, Character> map =new HashMap<String, Character>();
        int right = 0 , pleft = 0;
        for(int left = 0; right < str.length(); right++){
            if(pleft == pattern.length()) break;
            if( right == str.length()-1 || str.charAt(right+1) == ' '){
                if(map.containsKey(str.substring(left, right+1))){
                    if(map.get(str.substring(left, right+1)) != pattern.charAt(pleft)) return false;
                }else{
                    if(map.containsValue(pattern.charAt(pleft))) return false;
                    map.put(str.substring(left, right+1), pattern.charAt(pleft));
                }
                left = right+2;
                pleft++;
            }
        }
        return pleft == pattern.length() && right == str.length();
    }
	
	
	public boolean wordPattern(String pattern, String str) {
        //build a map store object-index pair;
        //check if map.get(key) == pattern.get(key);
        if(pattern == null && str == null) return true;
		else if(pattern == null || str == null) return false;
        Map<Object, Integer> map =new HashMap<Object, Integer>();
        String[] array = str.split(" ");
		if(array.length != str.length()) return false;
		Because "The JVM is caching Integer values. == only works for numbers between -128 and 127 "
        for(Integer i = 0; i < array.length; i++){
          if(map.put(array[i], i) != map.put(str.charAt(i))){
		      return false; 
		  }   
        }
        return true;
    }
}