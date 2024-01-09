package practice;

import java.util.Arrays;

/*You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

        Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

        Example 1:

        Input: [1,2,3,1]
        Output: 4
        Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
        Total amount you can rob = 1 + 3 = 4.
        Example 2:

        Input: [2,7,9,3,1]
        Output: 12
        Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
        Total amount you can rob = 2 + 9 + 1 = 12.
*/
public class House_Robber_198 {
    int[] dp; //max amt that can be robbed by the time this house is finished.

    /*
    A robber has 2 options: a) rob current house i; b) don't rob current house.
If an option "a" is selected it means she can't rob previous i-1 house but can safely proceed to the one before previous i-2 and gets all cumulative loot that follows.
If an option "b" is selected the robber gets all the possible loot from robbery of i-1 and all the following buildings.
So it boils down to calculating what is more profitable:

robbery of current house [i] + loot from houses before the previous i.e, [i-2]th house
    or
 loot from the previous house [i-1] th robbery and any loot captured before that

Time Complexity - O(n)
Space Complexity - O(1)
     */
    public int rob(int[] nums){
        dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return fun(nums, 0);
    }

    public int fun(int[] nums, int i){

        if(i > nums.length-1){
            return 0;
        }

        if(dp[i] != -1)
            return dp[i];

        dp[i] =  Math.max(fun(nums, i+2)+ nums[i], fun(nums, i-1));
        return dp[i];
    }

    public static void main(String[] args){
        House_Robber_198 h = new House_Robber_198();
        System.out.println(h.rob(new int[] {1,2,3,1})); // 1 (0th house) + 3 (2nd house) = 4
        System.out.println(h.rob(new int[] {1,2}));  // 2 (only 2 houses)
        System.out.println(h.rob(new int[] {1}));  // 1 (only 1 house)
        System.out.println(h.rob(new int[] {2,1,1,2})); // skipping atmost 2 houses. 2 + 2 = 4;
        System.out.println(h.rob(new int[] { /*TLE test case*/114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240}));
    }
}
