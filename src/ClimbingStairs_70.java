import java.util.Arrays;

public class ClimbingStairs_70 {
    int[] dp;
    public static void main(String[] args) {
        ClimbingStairs_70 c = new ClimbingStairs_70();
        System.out.println(c.climbStairs(1)); //1
        System.out.println(c.climbStairs(2)); //2
        System.out.println(c.climbStairs(3)); //3
        System.out.println(c.climbStairs(4)); //5
        System.out.println(c.climbStairs(5)); //8
        System.out.println(c.climbStairs(44)); //3  (TLE, if recursion without memory)
    }
    public int climbStairs(int n) {
        dp = new int[n];
        return climbStairsRecursion(0, n);
        //return climbStairsIteration( n);
    }
    public int climbStairsRecursion(int i, int n) {
        //when there are only two steps left then there are two ways to go - 1) step by step 2) takes jump of two steps
        if (i == n - 2) {
            return 2;
        }
        //when there is only one step left then there is only one way to go up
        if (i == n - 1)
            return 1;
        if(dp[i] != 0)
            return dp[i];
        int way1 = climbStairsRecursion(i + 1, n);
        int way2 = climbStairsRecursion(i + 2, n);
        dp[i] = way1 + way2;
        return dp[i];
    }

    public int climbStairsIteration(int n) {
        if (n == 0)
            return 0;
        if (n == 1)  //if there is 1 step, only 1 way to climb out.
            return 1;
        if (n == 2)  //if there are 2 steps, then 2 ways to climb out Eg: steps are A B C  --> A->B->C or A->C
            return 2;
        // out   0        1        2             3     --> 4 steps
        //       A        B        C             D
        //       1        2                            --> ways to climb out (imagine going left is going out)
        //      prev2    prev1   prev1+prev2=3   3+2=5
        int prev2 = 1;
        int prev1 = 2;
        for (int i = 2; i < n; i++) {
            int temp = prev1;
             prev1 = prev1 + prev2;
             prev2 = temp;
        }
        return prev1;
    }

    public int climbStairs2(int n) {
        if(n==1)   //needed because n could be 1, otherwise dp[n-2] = 2 line fail because dp[1-2] = dp[-1] does not exist.
            return 1;
        dp = new int[n];
        Arrays.fill(dp, -1);
        dp[n-1] = 1;
        dp[n-2] = 2;
        return climb(0);
    }

    public int climb(int i) {
        if(dp[i] != -1){
            return dp[i];
        }
        dp[i] = climb(i+1) + climb(i+2);
        return dp[i];
    }
}
