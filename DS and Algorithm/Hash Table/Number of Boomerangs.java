
/**
Number of Boomerangs  
Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:
Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
**/

public class Solution {
    public int numberOfBoomerangs(int[][] points) {
	     //record each distance as key
		 //count all nodes connect to original node with same distance
		 //2 * each node -- original node
		 Map<Integer, Integer> dismap = new HashMap<>();
		 int res = 0;
		 for(int i = 0; i < points.length; i++){
		    for(int j = 0; j < points.length; j++){
			  if(i != j){
			     dismap.putIfAbsent(distance(points[i], points[j]), 0);
				 res += 2 * dismap.get(distance(points[i], points[j]));
				 dismap.put(distance(points[i], points[j]), dismap.get(distance(points[i], points[j]))+1);
			  }
			}
			dismap.clear();
		 }
         return res;
    }
	
	public int distance(int[] a, int[] b){
	   int x = a[0] - b[0];
 	   int y = a[1] - b[1];
	   return x * x + y * y;
	}
}