/*
There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice. Start is always smaller than end. There will be at most 104 balloons.

An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart ¡Ü x ¡Ü xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely. The problem is to find the minimum number of arrows that must be shot to burst all balloons.

Example:

Input:
[[10,16], [2,8], [1,6], [7,12]]

Output:
2

Explanation:
One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).

*/

public class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0) return 0;
        //sort the ballons start and end
        //set a limit will contains as many ballons as possible
        //refresh the limit to obey the last standard
        //if out of the limit, add one arrow, refresh the limit
        Arrays.sort(points, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]) return ((Integer)a[1]).compareTo((Integer)b[1]);
                else  return ((Integer)a[0]).compareTo((Integer)b[0]);
            }
        });
        int limit = points[0][1];
        int minArrows = 1;
        for(int i = 1; i < points.length; i++){
            if(limit >= points[i][0]){
                limit = Math.min(limit, points[i][1]);
            }else{
                minArrows++;
                limit = points[i][1];
            }
        }
        return minArrows;
    }
}