/*
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 < numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.



Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].


Constraints:

2 <= numbers.length <= 3 * 104
-1000 <= numbers[i] <= 1000
numbers is sorted in non-decreasing order.
-1000 <= target <= 1000
The tests are generated such that there is exactly one solution.
 */

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumII_InputIsSorted_167 {

    //Time complexity - O(n)
    //Space complexity - O(1)
    //Two pointers
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0, j = nums.length - 1; i < nums.length; ) {
            if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                return new int[]{i + 1, j + 1}; //adding 1 because as per question 0th is the 1st index, 1st is the 2nd index.
            }
        }
        return new int[]{};
    }

    //Time complexity - O(n)
    //Space complexity - O(n)
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; //
            if (!numMap.containsKey(complement)) {
                numMap.put(nums[i], i); // Map maintains the input number and its index
            } else {
                return new int[]{numMap.get(complement) + 1, i + 1};  // as soon as one pair is found return indexes of both numbers. No need to search more.
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSumII_InputIsSorted_167 t = new TwoSumII_InputIsSorted_167();
        System.out.println(Arrays.toString(t.twoSum(new int[]{2, 7, 11, 15}, 9))); // 1,2
        System.out.println(Arrays.toString(t.twoSum(new int[]{2, 3, 4}, 6))); //[1,3]
        System.out.println(Arrays.toString(t.twoSum(new int[]{-1, 0}, -1))); //[1,2]
    }

}
