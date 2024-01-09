/*
On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

Example 1:
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
Example 2:
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 */

import java.util.Arrays;

public class Min_Cost_Climbing_Stairs_746 {
    int[] minCostArr;

    public static void main(String[] args) {
        Min_Cost_Climbing_Stairs_746 m = new Min_Cost_Climbing_Stairs_746();
        int[] cost = {10, 15, 20};
        System.out.println(m.minCostClimbingStairs(cost)); // 15
        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(m.minCostClimbingStairs(cost2)); //6

    }

    //recursion (top-down) - O(2^n) Time Limit Exceeded. (no memorization)
    /* [1,2,3,4,5, topfloor]  -
     to be in topfloor -  mincost(4th step) and mincost(5th step) has to be calculated.
     to be in 5th step  - mincost(4th step) and mincost(3rd step) has to be calculated
     to be in 4th step  - mincost(3rd step) and mincost(2nd step) has to be calculated
     ...so on
     So 3rd step cost is calculated twice for 5th step and 4th step.
    Similary 2nd step cost has to be calcuated for 5th step, 4th step, 3rd step. (no memorization)
    */
    public int minCostClimbingStairs_recursion(int[] cost) {
        //to climb all the stairs (index out of bound) the cost is minimum of previous 2 steps.
        return Math.min(minCost1(cost,cost.length-1), minCost1(cost,cost.length-2) );
    }
    public int minCost1(int[] cost, int idx) {

        //base cases
        if(idx < 0) //if idx/step is < 0 then no cost i.e., 0
            return 0;

        if(idx == 0 || idx ==1){  //if you have to take any of the first two steps then you pay as much.
            return cost[idx];
        }

        // if we take current idx step then cost = cost[i] + min(mincost(previousStep), mincost(2ndPreviousstep)
        return cost[idx] + Math.min(minCost1(cost,idx-1), minCost1(cost,idx-2));
    }


    public int minCostClimbingStairs(int[] cost) {
        minCostArr = new int[cost.length];
        Arrays.fill(minCostArr, -1);

        int step0 = findMinValue(cost, 0);
        int step1 = findMinValue(cost, 1);
        return step0 < step1 ? step0 : step1;
    }

    //recursion (top-down) - O(n)  (memorization)  //minCostClimbingStairs_recursion_memorization
    //space: O(n)
    public int findMinValue(int[] cost, int i) {
        if (i == cost.length - 1 || i == cost.length - 2) {  //if one of the last two steps.
            return cost[i];
        }

        if (minCostArr[i] != -1) {  //If already computed
            return minCostArr[i];
        }

        int oneStep = cost[i] + findMinValue(cost, i + 1);
        int twoStep = cost[i] + findMinValue(cost, i + 2);
        minCostArr[i] = oneStep < twoStep ? oneStep : twoStep;
        return minCostArr[i];
    }

    //recursion (top-down) - O(n)  (memorization)
    //space: O(N)
    public int minCostClimbingStairs2(int[] cost) {
        minCostArr = new int[cost.length];
        //to climb all the stairs (index out of bound) the cost is minimum of previous 2 steps.
        return Math.min( minCost2( cost,  cost.length-1, minCostArr), minCost2( cost,  cost.length-2, minCostArr));
    }

    public int minCost2(int[] cost, int idx, int[] minCostArr) {

        //base case
        if(idx == 0 || idx ==1){  //if you have to take any of the first two steps then you pay as much.
            minCostArr[idx] = cost[idx];
            return minCostArr[idx];
        }

        if (minCostArr[idx] !=0) //if already computed return it. (without this line it give TLE)
            return minCostArr[idx];

        // if we take current idx step then cost = cost[i] + min(mincost(previousStep), mincost(2ndPreviousstep)
        minCostArr[idx] = cost[idx] + Math.min(minCost2( cost,  idx-1, minCostArr) ,  minCost2( cost,  idx-2, minCostArr));
        return minCostArr[idx];
    }


}
