/*
Given an unsorted array of integers nums, return the length of the longest continuous increasing subsequence (i.e. subarray). The subsequence must be strictly increasing.

A continuous increasing subsequence is defined by two indices l and r (l < r) such that it is [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] and for each l <= i < r, nums[i] < nums[i + 1].



Example 1:

Input: nums = [1,3,5,4,7]
Output: 3
Explanation: The longest continuous increasing subsequence is [1,3,5] with length 3.
Even though [1,3,5,7] is an increasing subsequence, it is not continuous as elements 5 and 7 are separated by element
4.
Example 2:

Input: nums = [2,2,2,2,2]
Output: 1
Explanation: The longest continuous increasing subsequence is [2] with length 1. Note that it must be strictly
increasing.


Constraints:

1 <= nums.length <= 104
-109 <= nums[i] <= 109
 */

public class LongestContinuousIncreasingSubsequence674 {

    //Time : O(n)
    //Space: O(1)
    public int findLengthOfLCIS(int[] nums){

        int ans = 1;
        int cnt = 1;

        for(int i=1; i< nums.length; i++){
            if (nums[i] > nums[i-1]){
                cnt++;
            }
            else{
                if(cnt > ans) {
                    ans = cnt;
                }
                cnt = 1;
            }
        }

        if(cnt > ans) {  //if the input has all increasing numbers.
            ans = cnt;
        }
        return ans;
    }

    public static void main(String[] args){
        LongestContinuousIncreasingSubsequence674 l = new LongestContinuousIncreasingSubsequence674();
        System.out.println(l.findLengthOfLCIS(new int[] {1,3,5,7})); //4     //1,3,5,7 - input has all increasing numbers.
        System.out.println(l.findLengthOfLCIS(new int[] {1,3,5,4,7})); //3   //1,3,5
        System.out.println(l.findLengthOfLCIS(new int[] {1,3,5,4,7,8,10,11,9,6})); //4   //7,8,10,11
    }
}
