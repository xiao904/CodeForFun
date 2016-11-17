/*Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.*/

public class Solution {
    //use a map to store all Characters
	//sort the map entrys by the values;
	//output the chars iteratively
    public String frequencySort(String s) {
       Map<Character, Integer> charMap = new HashMap<>();
       StringBuilder sb = new StringBuilder();
       for(int i = 0; i < s.length(); i++){
           charMap.putIfAbsent(s.charAt(i), 0);
           charMap.put(s.charAt(i), charMap.get(s.charAt(i))+1);
       }
       List<Map.Entry<Character, Integer>> list = new ArrayList<>(charMap.entrySet());
       Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>(){
          @Override
          public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2){
              return e2.getValue().compareTo(e1.getValue());
          }
       });
       for(Map.Entry<Character, Integer> e : list){
           for(int k = 0; k < e.getValue(); k++){
               sb.append(e.getKey());
           }
       }
       return sb.toString();
    }
	
	public String frequencySort(String s) {
       //bucket sort
	   //store all count numbers for each character, record the max number of counts
       int[] bucket = new int[256];
       Map<Integer, List<Character>> map = new HashMap<>();
       StringBuilder sb = new StringBuilder();
       int maxCount = 0;
       for(int i = 0; i < s.length(); i++){
           bucket[s.charAt(i)]++;
           maxCount = Math.max(maxCount, bucket[s.charAt(i)]);
       }
       for(int i = 0; i < bucket.length; i++){
           int count = bucket[i];
           if(count == 0) continue;
           map.putIfAbsent(count, new ArrayList<Character>());
           map.get(count).add((char)i);
       }
       //loop from largest possible count number back to 0
       for(int i = maxCount; i > 0; i--){
           if(map.containsKey(i)){
              for(Character c : map.get(i)){
               for(int j = 0; j < i; j++){
                   sb.append(c);
               }
              }
           }
       }
       
       return sb.toString();
    }
}