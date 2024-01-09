import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;
// If Integer Array is palindrome or not
// Input: [1,2,0,2,1]
// Output: True
// Input: [1,3,3]
// Output: False

//Time - O(n), Space - no space
public class Palindrome_Integer_Array {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        int a[] = {1,2,0,2,1};
        int a2[] = {1,2,2,1};
        int a3[] = {1,2,1,2};
        int a4[] = {1,2,3,1,2};

        if(a.length == 0){
            System.out.println("true");
        }

        System.out.println( isPalindrome(a,  0, a.length-1)); // true
        System.out.println( isPalindrome(a2,  0, a2.length-1)); // true
        System.out.println( isPalindrome(a3,  0, a3.length-1)); //false
        System.out.println( isPalindrome(a4,  0, a4.length-1)); // false

    }

    public static boolean isPalindrome(int[] a, int start, int end){ // 2, 2

        //If i and j meet the same point
        if(start > end || start == end)
            return true;


        if(a[start] == a[end]){
            return isPalindrome( a, start + 1,  end - 1);
        }
        else {
            return false;
        }

    }


}
