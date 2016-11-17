/**

Given an interval list which are flying and landing time of the flight. How many airplanes are on the sky at most?

 Notice

If landing and flying happens at the same time, we consider landing should happen at first.

Example
For interval list

[
  [1,10],
  [2,3],
  [5,8],
  [4,7]
]
Return 3


**/

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) { 
       int max=0;
	   for(Interval interval:airplanes){
	       if(interval.end>max){
		      max=interval.end;
		   }
	   }
	   int[] count=new int[max+1];
	   for(Interval interval:airplanes){
	       count[interval.start]++;
		   count[interval.end]--;
	   }
	   int ans=0, t=0;
	   for(int i:count){
	      t+=i;
		  if(t<0) t=0;
		  if(t>ans) ans=t;
	   }
	   return ans;
    }
}