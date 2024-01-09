/*
Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].

Return true if there is a 132 pattern in nums, otherwise, return false.



Example 1:

Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.
Example 2:

Input: nums = [3,1,4,2]
Output: true
Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
Example 3:

Input: nums = [-1,3,2,0]
Output: true
Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].


Constraints:

n == nums.length
1 <= n <= 2 * 105
-109 <= nums[i] <= 109
 */

import java.util.Stack;

public class Stack_132Patter_456 {

    public boolean find132pattern(int[] nums) {
        for (int pos = 0; pos <= nums.length - 3; pos++) {

            int idx = pos;
            int count = 0;
            int i = 0, j = 0, k = 0;

            while (count < 3) {
                if (count == 0) {
                    i = nums[idx];
                } else if (count == 1) {
                    if (!(i < nums[idx])) {
                        break;
                    } else {
                        j = nums[idx];
                    }
                } else {
                    if ((j < nums[idx]) || (i > nums[idx])) {
                        break;
                    } else {
                        return true;
                    }
                }
                count++;
                idx++;
            }
        }
        return false;
    }

}
