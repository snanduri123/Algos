/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.



Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0


Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 10^4
 */

import java.util.Arrays;

public class CoinChange_322 { //Medium
    int[] minChangeForEachAmount; //use only for recursion. (iterative is better)


    //Time : O(amounts * coins) - for each i (from 1 to amount) you check for all given coins
    //Space: O(amount) - length of the dp array to store min change for each i(or amount)
    public int coinChange(int[] coins, int amount) {  //using iteration like fibonacci.
        Arrays.sort(coins);  //sorted so that if any coin does not makeup the amount then the rest of the coins on the right side need not be checked.
                             // amount = 3, coins = [5,2,4,6]. ---> [2,4,5,6]. you may start checking with coin 2 and then for coin 4 (4 > 3) it fails
                             // and no need to check for 5 and 6 and so on.
        if(amount == 0){
            return 0;
        }
        //each index in array represent the minchange  for amount from 1 to given amount. Eg: for amount 7, you are creating memory that can store
        // minchange for amounts 0,1,2,3,4,5,6,7 (for 0 amount, the change required is 0, so it is set to default 0).
        int[] dp = new int[amount + 1]; //memory to store the min change for amounts -  1 to amount (excluding 0 idx for 0 amt)
        Arrays.fill(dp,Integer.MAX_VALUE);

        dp[0] = 0;

        for(int i=1; i <= amount ; i++){
            for(int coin : coins){
                if(i - coin >= 0){  //if the coin value is lesser than the amount then it can be used (part of possible solution) Eg: coins = [2], amount = 3. first
                    if( dp[i - coin] != Integer.MAX_VALUE){
                        dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                    }
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];

    }


    //Time : O(amount * coins).
    //       In constraints, amount<=10^4 (10,000) and coins will be max of 12.
    //       In worst case, you have to end up finding  min change for every amount f(10000), f(9999), f(99998)...ie., 10000 and
    //                      with 12 coins????
    //Space: O(amount) = O(k)
    public int coinChange2(int[] coins, int amount) {  //using recursion.
        Arrays.sort(coins);
        if(amount == 0){
            return 0;
        }
         minChangeForEachAmount = new int[amount + 1]; //we need idx for 1 to amount (excluding 0 idx for 0 amt)
        int  ans = dp(coins, amount) ;
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public int dp(int[] coins, int amount){

        if(amount == 0){
            return 0;
        }

        if(minChangeForEachAmount[amount] !=0){
            return minChangeForEachAmount[amount];
        }
        int minChange  = Integer.MAX_VALUE;

        for(int coin : coins){
            if(coin > amount)
                //return -1;
                break;
            int minCoins = dp(coins, amount - coin);
            if (minCoins < Integer.MAX_VALUE) {
                minChange = Math.min(minChange, 1 + minCoins);
            }
        }
        minChangeForEachAmount[amount] = minChange;
        return minChange;
    }

    public static void main(String[] args){
        CoinChange_322 c = new CoinChange_322();
        System.out.println(c.coinChange(new int[]{1,3,4,5}, 7)); // 2. 3 + 4 = 7
        System.out.println(c.coinChange(new int[]{1,2,5}, 11)); // 3 . 5 + 5 + 1 = 11
        System.out.println(c.coinChange(new int[]{2}, 3)); // -1
        System.out.println(c.coinChange(new int[]{1}, 0)); // 0
        System.out.println(c.coinChange(new int[]{2,5,10,1}, 27)); // 4
        System.out.println(c.coinChange(new int[]{474,83,404,3}, 264)); // 8
    }
}
