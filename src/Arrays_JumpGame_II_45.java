/*
You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].



Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2


Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 1000
It's guaranteed that you can reach nums[n - 1].
 */

public class Arrays_JumpGame_II_45 { //
    //Time: O(n)
    //Space: O(1)
    /*BFS, at every step check to what range we can jump.
    //Eg:nums =  2 3 1 1 4
    //   idx  -  0 1 2 3 4

        1. At first when you are at 2 (i=0),
            a.maxIdxReached can be reached is i + nums[i] = 0 +2 =2).
            b.the range you can jump is to i=1 or i=2(idx+nums[i] = 0+2 = 2) which will be the next window.
        2. In that new window i = 1 to 2, again check what is the maxIdxReached and what is the next window range.
    */


    public int jump(int[] nums) {
        int windowStartIdx = 0;
        int windowEndIdx = 0;
        int maxReachedIdx = 0;
        int jumps = 0;
        while(maxReachedIdx < nums.length - 1){
            for(int i = windowStartIdx; i <= windowEndIdx; i++){
                maxReachedIdx = Math.max(maxReachedIdx, nums[i] + i);
            }
            jumps++;
            windowStartIdx = windowEndIdx + 1; //next window start after current window
            windowEndIdx = maxReachedIdx; //next window range is uptil the maxReachedidx
        }
        return jumps;
    }
}


