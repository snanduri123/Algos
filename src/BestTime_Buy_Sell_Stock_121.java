    /*Say you have an array for which the ith element is the price of a given stock on day i.

        If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

        Note that you cannot sell a stock before you buy one.

        Example 1:

        Input: [7,1,5,3,6,4]
        Output: 5
        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
        Not 7-1 = 6, as selling price needs to be larger than buying price.

        Example 2:

        Input: [7,6,4,3,1]
        Output: 0
        Explanation: In this case, no transaction is done, i.e. max profit = 0.
        */

public class BestTime_Buy_Sell_Stock_121 {

    public static void main(String[] args){
        int prices1[] = {7,1,5,3,6,4};
        System.out.println(" profit by brute force approach: " + maxProfit_bruteFore( prices1)); //5

        System.out.println(" profit : " + maxProfit( prices1)); //5

        int prices2[] = {3,3,5,0,0,3,1,4};
        System.out.println(" profit : " + maxProfit( prices2)); //4-0 = 4

        int prices3[] = {2,1,2,1,0,1,2};
        System.out.println(" profit : " + maxProfit( prices3)); //2-0 = 2

        int prices4[] = {2,1,2,0,1};
        System.out.println(" profit : " + maxProfit( prices4)); // 2 - 1 = 1 or 1 - 0 = 1

        int prices5[] = {2,4,1};
        System.out.println(" profit : " + maxProfit( prices5)); // 4 - 2 = 2

        int prices6[] = {7,6,4,3,1};
        System.out.println(" profit : " + maxProfit( prices6)); // 0

        int prices7[] = {7,1,5,3,6,4};
        System.out.println(" profit : " + maxProfit( prices7)); // 6 - 1 = 5
    }

    //1 Brute force :  Time complexity - n^2. Space complexity - O(1)
    public static int maxProfit_bruteFore(int prices[]) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
    }

    //2  Time complexity - n.
    // Space complexity - O(1)
    //Keep tracking the minPrice. Whenever there is higher price check if the profit is more than last profit.
    public static int maxProfit(int[] prices) {

        int min_price = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= min_price)
                min_price = prices[i];
            profit = Math.max(profit, prices[i] - min_price);
        }
        return profit;
    }


}
