/**Given array with positive and negative values, return the maximum alternating slice size, two elements are alternating if they have different signs, zero is treating as both negative and positive.

Example
Given a = [1, -5, 23, 0, 1, 1, 0, 2, -5, 3, -1, 1, 2, 3] return 7 (the sequence [1, 0, 2, -5, 3, -1, 1] has maximum alternating slice size )

The expected runtime is o(n).*//


public class Solution{

    public int maxAlternationSliceSize(int[] a){
        /**
        1 -1 ok
        1/-1 0 ok
        0 0 ok
        -1 1 ok
        1  1 not ok
        -1 -1 not ok
        a[i]*a[i-1]<=0 continue
        a[i]*a[i-1]>0 break; return the length;
        currentindex=i; 
        **/
        int max=0;
        for(int start=0,i=1;i<a.length;i++){
           if((long)a[i]*(long)a[i-1]>0){
               max=Math.max(max,i-start);
               start=i;
           }
        
        }
        return max;
    }


}
