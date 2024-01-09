/*
Given a positive integer num, return true if num is a perfect square or false otherwise.

A perfect square is an integer that is the square of an integer. In other words, it is the product of some integer with itself.

You must not use any built-in library function, such as sqrt.



Example 1:

Input: num = 16
Output: true
Explanation: We return true because 4 * 4 = 16 and 4 is an integer.
Example 2:

Input: num = 14
Output: false
Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an integer.


Constraints:

1 <= num <= 231 - 1
 */

public class ValidPerfectSquare {


    //Time: O(logn) - binarySearch
    //Space: O(1)
    public boolean isPerfectSquare(int n) {

        if (n < 2) {   //if n is 1 or 0 then it is perfect square.
            return true;
        }

        //if n>= 2 the square root is always less than n/2.
        /*
        The reason we are using long data type in the second approach to hold the
        current approximated value is to prevent integer overflow.
        The question states that num fits in a 32-bit signed integer (max value 2^31-1).
        Therefore mid could be as large as ((2^31-1)/2)^2 = 1152921503533105200 which will cause wrap around
        if we use int which is 32-bit.
         */
        long left = 2;  //if long datatype is not used then false is returned for 808201 instead of true.
        long right = n / 2;
        long x, guessSquared;

        while (left <=right) {
             x = (left +right)/2; //mid = left + (right - left) / 2;

            guessSquared = x * x;
            if (guessSquared == n)
                return true;
            if (guessSquared > n){
                right = x - 1;
            }
            else{
                left = x + 1;
            }
        }
        return false;
    }

    public static void main(String[] args){
        ValidPerfectSquare v = new ValidPerfectSquare();
        System.out.println(v.isPerfectSquare(16)); //true
        System.out.println(v.isPerfectSquare(1)); //true
        System.out.println(v.isPerfectSquare(2)); //false
        System.out.println(v.isPerfectSquare(3)); //false
        System.out.println(v.isPerfectSquare(2147483647)); //false
        System.out.println(v.isPerfectSquare(808201)); //true
    }
}
