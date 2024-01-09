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
    public int rob(int[] nums) {
        if(nums == null || nums.length ==0)
            return 0;
        int prev1 = 0; //prev1 holds maximum loot obtained till i-1th house.
        int prev2 = 0; //prev2 holds maximum loot obtained till i-2th house.
        for(int i =0 ; i < nums.length; i++) {
            int temp = prev1;
            prev1 = Math.max(nums[i] + prev2, prev1);
            prev2 = temp;
        }
       return prev1;
    }

    //Time : O(n)
    //Space: O(n)

    public int robIterativeWithDP(int[] nums){  //Actually DP memory is not needed for iterative approach. Just follow above simple iterative.
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        if(nums == null)
            return 0;

        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        int maxAmount = dp[1];
        for(int i = 2; i<nums.length; i++){
            maxAmount = Math.max(dp[i-1], dp[i-2]+nums[i]);
            dp[i] = maxAmount;
        }
        return maxAmount;
    }

    public int robFromLeft(int[] nums) { //going from left to right
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        if(nums == null || nums.length ==0)
            return 0;
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        return robdp( nums,  0); //max loot that may include 0th house or not.
    }
    public int robdp(int[] nums, int i){

        if (i >= nums.length) {  //if search goes beyond input length then terminate. this will be helpful for calculating loot for last two houses.
            return 0;
        }
        if(dp[i] >= 0){  // look up for previously calculated houses.
            return dp[i];
        }
        dp[i] = Math.max(robdp(nums,i+1), robdp(nums,i+2) + nums[i]);
        return dp[i];

    }

    public int robFromRight(int[] nums){ //going from right to left
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        if(nums == null)
            return 0;

        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        //this initialization is not needed because in recursion the value of dp[0] and dp[1]
        // will be calculated and will come out same as the nums[0] and num[1] respectively
        //Eg: for dp[0] = fun(nums, i-2,dp) + nums[i] = 0 + nums[0]
        //    for dp[1] = math.max(fun(nums, i-2,dp) + nums[i], dp[0]) = math.max(0+nums[1],nums[0])
//        dp[0] = nums[0];
//        dp[1] = Math.max(nums[0], nums[1]);

        return fun(nums, nums.length-1,dp);

    }
    public int fun(int[] nums, int i, int[] dp){

        if(i<0)
        {
            return 0;
        }
        if(dp[i] != -1)
            return dp[i];

        dp[i] =  Math.max(fun(nums, i-2,dp) + nums[i], fun(nums, i-1,dp));
        return dp[i];
    }

    public static void main(String[] args){
        House_Robber_198 h = new House_Robber_198();
        System.out.println(h.rob(new int[] {5,11,4,2,7})); // 11 (1st house) + 7 (4th house) = 18
//        System.out.println(h.rob(new int[] {1,2,3,1})); // 1 (0th house) + 3 (2nd house) = 4
//        System.out.println(h.rob(new int[] {1,2}));  // 2 (only 2 houses)
//        System.out.println(h.rob(new int[] {1}));  // 1 (only 1 house)
//        System.out.println(h.rob(new int[] {2,1,1,2})); // skipping atmost 2 houses. 2 + 2 = 4;
//        System.out.println(h.rob(new int[] { /*TLE test case*/114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240}));
    }
}
