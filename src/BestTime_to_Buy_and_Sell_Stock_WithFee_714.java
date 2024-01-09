/*
        Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

        Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

        Example 1:

        Input: [7,1,5,3,6,4]
        Output: 7
        Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
        Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
        Example 2:

        Input: [1,2,3,4,5]
        Output: 4
        Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
        Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
        engaging multiple transactions at the same time. You must sell before buying again.
        Example 3:

        Input: [7,6,4,3,1]
        Output: 0
        Explanation: In this case, no transaction is done, i.e. max profit = 0.
        */

public class BestTime_to_Buy_and_Sell_Stock_WithFee_714 {


    public static void main(String[] args) {
        int profit = 0;

        profit = maxProfit(new int[]{1,3,2,8,4,9},2); // ((8 - 1) - 2) + ((9 - 4) - 2) = 8
        System.out.println(" profit : " + profit);
//        profit = maxProfit(new int[]{6, 1, 5, 3, 6, 4}); // (5-1) + (6-3)= 4 + 3 = 7
//        System.out.println(" profit : " + profit);
//        profit = maxProfit(new int[]{7, 6, 4, 3, 1}); //0 descending
//        System.out.println(" profit : " + profit);
//        profit = maxProfit(new int[]{2, 4, 1});  //2
//        System.out.println(" profit : " + profit);
//        profit = maxProfit(new int[]{2, 3, 4, 6});  //4 //ascending
//        System.out.println(" profit : " + profit);
//        profit = maxProfit(new int[]{2, 1, 2, 0, 1});  //2  //initially too high and ending too low
//        System.out.println(" profit : " + profit);
//        profit = maxProfit(new int[]{2, 1, 2, 1, 0, 1, 2}); //3
//        System.out.println(" profit : " + profit);
//        profit = maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}); //8
//        System.out.println(" profit : " + profit);
    }

    //Time complexity : O(n)
    //Space complexity: O(1)
    public static int maxProfit(int[] prices, int fee) {

        int minSoFar = prices[0]; //first day price is min
        int maxSoFar = prices[0]; //first day price is max
        int TotalProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            //If you see a dip in curr price then we have to calculate the profit for
            // the so far seen max and so far seen min.
            // Reset them to curr price.
            if (prices[i] < minSoFar || prices[i] < maxSoFar) {
                int profit = maxSoFar - minSoFar - fee;
                TotalProfit = TotalProfit + profit;
                minSoFar = prices[i];  //because profit is already calculated for prevmin and prevmax
                maxSoFar = prices[i];   //update again min and max to curr price.
            } else if (prices[i] > maxSoFar) {
                maxSoFar = prices[i];
            }
        }
                                  //the below code is when the test case is complete ascending or when the price became ascending from new dip.
        if (minSoFar < maxSoFar)  //the last index price could be the maxSoFar, but above the profit is not yet calculated, so we calculate it here
            TotalProfit += maxSoFar - minSoFar;
        return TotalProfit;
    }
}
