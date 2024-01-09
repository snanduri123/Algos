package Concepts;

import java.util.HashSet;

/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example:

Input: 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

 Happy numbers  are1, 7, 10, 13, 19, 23, 28, 31, 32, 44, 49, 68, 70, 79, 82, 86, 91, 94, 97, 100, ...
 unhappy numbers are 2, 3, 4, 5, 6, 8, 9, 11, 12, 14, 15, 16, 17, 18, 20, ...

 Eg: of unhappy -  2
 2*2 + 0 = 4
 4*4 + 0 = 16
 1*1 + 6*6 = 37
 3*3 + 7*7 = 58
 5*5 + 8*8 = 89
 8*8 + 9*9 = 145
 1*1 + 4*4 + 4*5 = 42
 4*4 + 2*2 = 20
 2*2 + 0*0 = 4  (again 4 came.....)

 */
public class HappyNumbers_202 {

    public boolean isHappy(int n) {

        HashSet<Integer> set = new HashSet<Integer>(); //for unhappy numbers, one of the sums will appear again Eg: 2, 4

        while(!set.contains(n)){
            set.add(n);

            n = getSum_Of_Squares_Of_Digits(n);

            if(n==1)
                return true;
        }

        return false;

    }


    public int getSum_Of_Squares_Of_Digits(int n){
        int sum =0;
        while(n>0){
            int rem = n%10;
            sum = sum + rem*rem;
            n=n/10;
        }
        return sum;
    }

}
