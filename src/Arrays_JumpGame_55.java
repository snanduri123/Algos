/*
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.



Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.


Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 105
 */

public class Arrays_JumpGame_55 {

    //Time: O(n)
    //Space: O(1)
    public boolean canJump(int[] nums) {
        int maxReachedIndex = 0;
        if (nums.length <= 1) {  //if there is only one index then it is already at last index.
            return true;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            //if you are at an index where you can't take any more steps and
            // so far reached maxIndex is also current index then you can't go forward so return false.
            if (nums[i] == 0 && maxReachedIndex == i)
                return false;
            maxReachedIndex = Math.max(i + nums[i], maxReachedIndex); //how forward you can go from curr idx.
            if (maxReachedIndex >= nums.length - 1)
                return true;
        }
        return false;
    }

//    int[] dp;
//    public boolean canJump(int[] nums) {
//        dp = new int[nums.length];
//
//        if (nums.length <= 1) {  //if there is only one index then it is already at last index.
//            return true;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (canJumpToLast(nums, 0)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean canJumpToLast(int[] nums, int jumpFromPos) {
//        if (dp[jumpFromPos] == -1)
//            return false;
//        if (jumpFromPos == nums.length - 1)
//            return true;
//        for (int steps = 1; steps <= nums[jumpFromPos]; steps++) {   //at every index in input, you can take choices - 0 to nums[idx] steps. So for every choice check if you can reach to last step.
//            if (canJumpToLast(nums, jumpFromPos + steps))
//                return true;
//        }
//        dp[jumpFromPos] = -1;  //memorize that from this position you can't jump
//        return false;
//    }

    public static void main(String[] args) {
        Arrays_JumpGame_55 A = new Arrays_JumpGame_55();
//        System.out.println(A.canJump(new int[]{2, 3, 1, 1, 4})); //true
//        System.out.println(A.canJump(new int[]{3, 2, 1, 0, 4})); // false
//        System.out.println(A.canJump(new int[]{0})); // true
//        System.out.println(A.canJump(new int[]{2, 0, 0})); // true
//        System.out.println(A.canJump(new int[]{0, 2, 3})); // false
//        System.out.println(A.canJump(new int[]{3,0,8,2,0,0,1})); // true
        System.out.println(A.canJump(new int[]{1,0,1,0})); // true
    }
}


