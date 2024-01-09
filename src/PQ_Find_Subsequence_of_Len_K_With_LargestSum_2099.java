import java.util.Arrays;
import java.util.PriorityQueue;

/*
You are given an integer array nums and an integer k. You want to find a subsequence of nums of length k that has the largest sum.

Return any such subsequence as an integer array of length k.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.



Example 1:

Input: nums = [2,1,3,3], k = 2
Output: [3,3]
Explanation:
The subsequence has the largest sum of 3 + 3 = 6.
Example 2:

Input: nums = [-1,-2,3,4], k = 3
Output: [-1,3,4]
Explanation:
The subsequence has the largest sum of -1 + 3 + 4 = 6.
Example 3:

Input: nums = [3,4,3,3], k = 2
Output: [3,4]
Explanation:
The subsequence has the largest sum of 3 + 4 = 7.
Another possible subsequence is [4, 3].


Constraints:

1 <= nums.length <= 1000
-105 <= nums[i] <= 105
1 <= k <= nums.length
 */
public class PQ_Find_Subsequence_of_Len_K_With_LargestSum_2099 {
    public int[] maxSubsequence(int[] nums, int k) {
        Arrays.sort(nums);
        int[] ans = new int[k];

        for(int i = nums.length - 1, j = k-1; i >= nums.length - k ; i--){
            ans[j--] = nums[i];
        }
        return ans;
    }


    //Time : O(n) reading input + O(nlogk) - inserting n elem/removing k elem from heap1 + O(klogk) inserting and reading k elem from heap2
    //Space: O(k) = O(k) heap1 + O(k) heap2
    public int[] maxSubsequence2(int[] nums, int k) {

        int[] ans = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); //to order based on highest value of an index. Ascending order, so that smaller numbers can be popped first.
        for (int i =0; i<nums.length; i++) {
            int[] idxValue = new int[]{i,nums[i]};
            pq.add(idxValue);
            if (pq.size() > k){
                pq.poll();
            }
        }

        PriorityQueue<int[]> pq2 = new PriorityQueue<>((a, b) -> a[0] - b[0]); // to order based on index. or add it to list/array and sort the list/array.
        pq2.addAll(pq);

        int i=0;
        while(!pq2.isEmpty()){
            ans[i] = pq2.poll()[1];
            i++;
        }
        return ans;
    }
    public static void main(String[] args) {
        PQ_Find_Subsequence_of_Len_K_With_LargestSum_2099 M = new PQ_Find_Subsequence_of_Len_K_With_LargestSum_2099();
        System.out.println(Arrays.toString(M.maxSubsequence(new int[]{2,1,3,3},2))); // [3,3]
        System.out.println(Arrays.toString(M.maxSubsequence(new int[]{-1,-2,3,4}, 3))); // [-1,3,4]
        System.out.println(Arrays.toString(M.maxSubsequence(new int[]{3,4,3,3}, 2))); // [3,4]
        System.out.println(Arrays.toString(M.maxSubsequence(new int[]{50,-75}, 2))); // [50,-75]

    }
}
