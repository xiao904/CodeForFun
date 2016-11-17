/*Description:

Count the number of prime numbers less than a non-negative number, n.

Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.
*/

public class Solution {
    
    /*To find all the prime numbers less than or equal to 30, proceed as follows.

First generate a list of integers from 2 to 30:

 2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30.
The first number in the list is 2; cross out every 2nd number in the list after 2 by counting up from 2 in increments of 2 (these will be all the multiples of 2 in the list):

 2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30.
The next number in the list after 2 is 3; cross out every 3rd number in the list after 3 by counting up from 3 in increments of 3 (these will be all the multiples of 3 in the list):

 2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30.
The next number not yet crossed out in the list after 3 is 5; cross out every 5th number in the list after 5 by counting up from 5 in increments of 5 (i.e. all the multiples of 5):

 2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30.
The next number not yet crossed out in the list after 5 is 7; the next step would be to cross out every 7th number in the list after 7, but they all have been crossed out at this point, as these numbers (14, 21, 28) are also multiples of smaller primes because 7*7 is greater than 30. The numbers not crossed out in the list at this point are all the prime numbers below 30:

 2  3     5     7           11    13          17    19          23                29.*/
    public int countPrimes(int n) {
        if(n <= 2) return 0;
        boolean[] sieves = new boolean[n];
        Arrays.fill(sieves, 2, n,true);
        for(int i = 2; i*i < n; i++){
            if(!sieves[i]) continue;
            for(int j = i*i; j < n; j += i){
                sieves[j] =false;
            }
        }
        int count = 0;
        for(boolean b : sieves){
            if(b) count++;
        }
        return count;
    }
}