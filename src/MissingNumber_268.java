/*
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.



Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
Example 2:

Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
Example 3:

Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.


Constraints:

n == nums.length
1 <= n <= 104
0 <= nums[i] <= n
All the numbers of nums are unique.

 */

public class MissingNumber_268 {

    //Time: O(n)
    //Space: O(1)
    public int missingNumber(int[] nums) {

        int rangeSum = 0;
        int numSum = 0;

        for(int i =0, num = 1; i< nums.length; i++, num++) { //range is 1<= num <= 10^4

            rangeSum = rangeSum + num;
            numSum = numSum + nums[i];
        }
        return rangeSum - numSum;
    }

    public static void main(String[] args) {

        MissingNumber_268 m = new MissingNumber_268();

        int[] nums1 = {9,6,4,2,3,5,7,0,1};

        System.out.println(m.missingNumber(nums1));
    }
}
