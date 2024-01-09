import java.util.Arrays;

/*You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected,
 and it will automatically contact the police if two adjacent houses were broken into on the same night.

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
public class House_Robber_II_213 {

/*Hint: Since House[1] and House[n] are adjacent, they cannot be robbed together.
Therefore, the problem becomes to rob either House[1] to House[n-1] or House[2] to House[n],
depending on which choice offers more money. Now the problem has degenerated to the House Robber,
 which is already been solved.
  */

/*
Time Complexity - O(n)
Space Complexity - O(1)
     */

    int[] dp;
    public int rob(int[] nums) {
        if(nums == null || nums.length ==0)
            return 0;

        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0], nums[1]);

        dp = new int[nums.length];

        Arrays.fill(dp, -1);
        int opt1 = nums[0] + robdp(nums,2,true);

        Arrays.fill(dp, -1); //***** important step
        int opt2 = robdp(nums,1,false);

        return Math.max(opt1, opt2);
    }

    public int robdp(int[] nums, int i, boolean isFirstHouseRobbed) {
        if(i >= nums.length)
            return 0;

        if (i == nums.length - 1) {
            if (isFirstHouseRobbed) {
                return 0;
            }
        }
        if (dp[i] >= 0) {
            return dp[i];
        }
        dp[i] = Math.max(robdp(nums, i + 2, isFirstHouseRobbed) + nums[i], robdp(nums, i + 1, isFirstHouseRobbed));

        return dp[i];
    }
    public static void main(String[] args){
        House_Robber_II_213 h = new House_Robber_II_213();
        System.out.println(h.rob(new int[] {2,3,2})); // 3(only 1 st house is robbed)
        System.out.println(h.rob(new int[] {1,2}));  // 2 (only 2 houses)
        System.out.println(h.rob(new int[] {1}));  // 1 (only 1 house)
        System.out.println(h.rob(new int[] {1,2,3,2})); // 1 + 3 or 2 + 2 = 4
        System.out.println(h.rob(new int[] {2,1,1,2})); // 3  (last house should not be taken because 1st house is robbed)
        System.out.println(h.rob(new int[] {1,3,1,3,100})); // 103
    }
}
