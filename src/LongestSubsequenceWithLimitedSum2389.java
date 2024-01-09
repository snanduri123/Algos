/*
You are given an integer array nums of length n, and an integer array queries of length m.

Return an array answer of length m where answer[i] is the maximum size of a subsequence that you can take from nums such that the sum of its elements is less than or equal to queries[i].

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.



Example 1:

Input: nums = [4,5,2,1], queries = [3,10,21]
Output: [2,3,4]
Explanation: We answer the queries as follows:
- The subsequence [2,1] has a sum less than or equal to 3. It can be proven that 2 is the maximum size of such a subsequence, so answer[0] = 2.
- The subsequence [4,5,1] has a sum less than or equal to 10. It can be proven that 3 is the maximum size of such a subsequence, so answer[1] = 3.
- The subsequence [4,5,2,1] has a sum less than or equal to 21. It can be proven that 4 is the maximum size of such a subsequence, so answer[2] = 4.
Example 2:

Input: nums = [2,3,4,5], queries = [1]
Output: [0]
Explanation: The empty subsequence is the only subsequence that has a sum less than or equal to 1, so answer[0] = 0.


Constraints:

n == nums.length
m == queries.length
1 <= n, m <= 1000
1 <= nums[i], queries[i] <= 106
 */

import java.util.Arrays;

public class LongestSubsequenceWithLimitedSum2389 {


    //Time:  O((q+n)logn)
    //Space: O(n) //extra space is used when we sort nums in place
    public int[] answerQueries(int[] nums, int[] queries) {

        int[] ans = new int[queries.length];

        Arrays.sort(nums);  //sort

        for (int i = 1; i < nums.length; ++i) // prefix sum. Every next element holds sum uptil then.
            nums[i] += nums[i - 1];

        int n = queries.length;

        for (int i = 0; i < n; ++i) {
            int index = binarySearch(nums, queries[i]);
            ans[i] = index;
        }

        return ans;
    }

    int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid + 1;
            if (nums[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return nums[start] > target ? start : start + 1;
        //In testcase  nums: {1,2,4,5}, queries: {4,11,21}
        // nums sorted and added sum of previous element --> {1,3,7,12}
        // (in queries) for 4  we need 1 and 2 in nums array and their sum "3" < 4 is at index 1 (second element) in sorted nums array.
        //                     But binary search method returns index start=2 (third position) of sorted nums array (nums[start] > target is success : 7 > 4)
        //                     indicating that it needs 2 elements in sorted nums array.
        //              for 11 we need 1,2,4 from nums array and their sum "7" < 11 is at index 3 (3rd element) in sorted nums array.
        //                     But binary search method returns index start=3 (fourth position) of sorted nums array (nums[start] > target is success : 12 > 11)
        //                     indicating that it needs 3 elements in sorted nums array.
        //              for 21 we need 1,2,4,5 from nums array and their sum "12" < 21 is at index 3 (4th element) in sorted nums array.
        //                     But binary search method returns index 3 (fourth position) + 1 = 4 (because nums[start] > target FAILS : 12 < 21)
        //                     indicating that it needs 4 elements in sorted nums array.
    }

    //Time: O(n * q ) + O(nlogn) = O(n * q  + nlogn)
    //Space: O(n) //extra space is used when we sort nums in place
    public int[] answerQueries2(int[] nums, int[] queries) {

        int[] ans = new int[queries.length];

        Arrays.sort(nums);

        for(int i = 0; i < queries.length; i++) {
            int sum=0;
            int count = 0;
            for(int j =0; j < nums.length; j++){
                sum = sum + nums[j];
                if(sum <= queries[i]){
                    count++;
                    ans[i] = count;
                }
                else{
                    break;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args){
        LongestSubsequenceWithLimitedSum2389 l = new LongestSubsequenceWithLimitedSum2389();
       // System.out.println(Arrays.toString(l.answerQueries(new int[] {4,5,2,1}, new int[]{3,10,21})));
        System.out.println(Arrays.toString(l.answerQueries(new int[] {1,2,4,5}, new int[]{4,11,21})));

    }

}
