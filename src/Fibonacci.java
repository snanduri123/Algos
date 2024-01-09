import java.math.BigInteger;

public class Fibonacci {

    static long[] a;

    static BigInteger[] b;


    //fibonacci series : 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
    // position        : 0, 1, 2, 3, 4, 5, 6, 7,  8,  9,  10, 11, 12

    public static void main(String args[]) {

//        int n = 9;
//
//        System.out.println("using recursion. Give n that is only like 50 otherwise it encounters stack over flow error" + fibNumAtGivenPosition_recursion(n));
//        System.out.println("printing fib series ");
//        printFibonocciSeriesUntilGivenPositon(n);
//
//        a = new long[n + 1];
//        a[0] = 0;
//        a[1] = 1;
//
//
//        //   System.out.println("using dynamic programing. Give n that is only like 1000 otherwise it encounters stack over flow error " );
//           System.out.println(fibNumAtGivenPosition_DynamicProgramming(n));
//
//        b = new BigInteger[n + 1];
//        b[0] = BigInteger.valueOf(0);
//        b[1] = BigInteger.valueOf(1);
//        System.out.println("using iterative and dynamic programing. The best approach");
//        System.out.println(fibNumAtGivenPosition_Iterative(n));
//
//

        //largest fibonacci lesser than a num
        System.out.println(fib2(8)); //21

        //largest fibonacci lesser than a num
       // System.out.println(fib_lesserthanNum(25));


    }

    /*Time Complexity : 2^n  ( 1. For f(n) we have to calcuate f(n-1) and f(n-2).
                               2. For f(n-1) we have to calculate f(n-2) and f(n-3) and so on..until n times.
                               3. For f(n-2) we have to calculate it again instead of reusing the value calculated in step2
                              So it is like binary tree. And for n depth of balanced tree, it contains 2^n nodes. So we have to calculate fib
                              for 2^n times)

    Space Complexity - heap  : constant ( because not using any heap memory)
                       stack : n (The max calls in the stack memory will be n because - max stack arrangement  f(n) -> f(n-1) -> f(n-2)....f(n-n)
                                 (visualize the binary tree and see that all the left most nodes of the tree being in stack)
                               For bigger n value, this approach encounters stack over flow error because of n stacked calls

                                 f(5)
                     /                            \
                  f(4)                            f(3)
             /            \                     /      \
           f(3)            f(2)                f(2)      f(1)
          /     \         /     \              /    \       \
         f(2)    f(1)    f(1)    f(0)        f(1)   f(1)     f(0)
        /         \     /                   /       /
       f(1)       f(0)  f(0)               f(0)    f(0)
      /
     f(0)

     */


    public static int fibNumAtGivenPosition_recursion(int n) {

        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        int num = fibNumAtGivenPosition_recursion(n - 1) + fibNumAtGivenPosition_recursion(n - 2);
        return num;

    }


    /*Time Complexity : n  ( 1. For f(n) we have to calcuate f(n-1) and f(n-2).
                               2. For f(n-1) we have to calculate f(n-2) and f(n-3) and so on..until n times. And each value of given position (ie.,n) is stored in an array
                               3. For f(n-2) we do not have to calculate it again as we can reuse the value calculated in step2
                               So it is like only left nodes in the binary tree with n positions
     Space Complexity - heap  : n (we store value of each position in an array)
                        stack : n (The max calls in the stack memory will be n because - max stack arrangement  f(n) -> f(n-1) -> f(n-2)....f(n-n)
                                  (visualize the binary tree and see that all the left most nodes of the tree being in stack)
                                  For bigger n value, this approach encounters stack over flow error because of n stacked calls
                f(5)
               /
              f(4)
             /
           f(3)
          /
         f(2)
        /
       f(1)
      /
     f(0)

      */
    public static long fibNumAtGivenPosition_DynamicProgramming(int n) {

       /* if (n == 0)
            return 0;
        if (n == 1)
    }

            return 1;

        if (a[n] != 0)*/

        if ((n != 0 && a[n] != 0) || n == 0)
            return a[n];
        else {
            a[n] = fibNumAtGivenPosition_DynamicProgramming(n - 1) + fibNumAtGivenPosition_DynamicProgramming(n - 2);
            return a[n];
        }
    }

    /*Time Complexity : n ( 1. Starting from position 1 find the fib series value and store it in the array so that it can be used for its next two positions
     Space Complexity - heap  : n (we store value of each position in an array)
                        stack : 1 (constant) (at any give time only one call will be in the stack - f(1) or f(2) or f(3) or .. f(n).
                                So this approach will not encounter stackover flow.
      Best Approach.

      */
    public static BigInteger fibNumAtGivenPosition_Iterative(int n) {

        for (int i = 2; i <= n; i++) {
            //fibNumAtGivenPosition_DynamicProgramming(n);
            b[i] = b[i - 1].add(b[i - 2]);
        }
        return b[n];

    }

    public static void printFibonocciSeriesUntilGivenPositon(int num) {

        for (int i = 0; i < num; i++) {
            System.out.println(fibNumAtGivenPosition_recursion(i));
        }

    }

    // 0, 1, 1, 3, 5, 8, 11, 21, 34
    // 0  1  2  3  4  5  6   7   8
    //Time : O(n)
    //Space: O(n)
    public int fib(int n) {  //****Iteration with memory ****/

        if(n==0)
            return 0;

        if(n==1)
            return 1;

        int[] fib = new int[n + 1]; // for fib(2) we need array of size 3.

        fib[0] = 0;
        fib[1] = 1;

        for(int i = 2; i <= n ; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }

        return fib[n];
    }

    // 0, 1, 1, 3, 5, 8, 11, 21, 34
    // 0  1  2  3  4  5  6   7   8
    //Time : O(n)
    //Space: O(1)
    public static int fib2(int n) {  //****Iteration without memory ****/

        if(n==0)
            return 0;

        if(n==1)
            return 1;

        //int[] fib = new int[n + 1]; // for fib(2) we need array of size 3.

        int prev1 = 1;
        int prev2 = 0;

        int curr=0;

        for(int i = 2; i <= n ; i++){
             curr = prev1 + prev2;
             prev2 = prev1;
             prev1 = curr;
        }

        return curr;
    }


    //24 is the largest fibonacchi number that is lesser than 25.
    public static int fib_lesserthanNum(int n) {  //****Iteration****/

        if(n < 1)
            return 0;

        if(n < 2)
            return 1;

        int prevFib = 1;
        int currFib = 2;

        for(int i = 2; currFib + prevFib <= n ; i++){
            int temp = currFib + prevFib;
             prevFib = currFib;
             currFib = temp;
        }

        return currFib;
    }
}
