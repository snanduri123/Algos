/*
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.



Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2


Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 { //medium

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        return threeSum_threePointer(nums);
        //threeSum_recur_with_duplicates(nums, 0, 0, new ArrayList<>());
        //return ans;
    }

    //Time :
    public List<List<Integer>> threeSum_threePointer(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; ) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    answer.add(list);
                    int currJVal = nums[j];
                    while (j < k && nums[j] == currJVal) {
                        j++;
                    }
                    int currKVal = nums[k];
                    while (j < k && nums[k] == currKVal) {
                        k--;
                    }

                } else {
                    if (nums[j] + nums[k] >= 0 - nums[i]) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }

            int currIval = nums[i];
            while (i < nums.length && nums[i] == currIval) {
                i++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        ThreeSum_15 s = new ThreeSum_15();
        System.out.println(Arrays.deepToString(s.threeSum(new int[]{-4, -1, -1, 0, 1, 2}).toArray())); // [[-1,-1,2],[-1,0,1]]
        System.out.println(Arrays.deepToString(s.threeSum(new int[]{0, 0, 0, 0}).toArray())); // [[0,0,0]]
        System.out.println(Arrays.deepToString(s.threeSum(new int[]{-1, 1, -1, 0}).toArray())); // [[0,0,0]]
    }

    //Time : 2 ^n
    //
    public void threeSum_recur_with_duplicates(int[] nums, int pos, int currSum, List<Integer> currList) {

        if (currSum == 0 && currList.size() == 3) {
            ans.add(new ArrayList<>(currList));
            return;
        }

        if (pos == nums.length) {
            return;
        }

        threeSum_recur_with_duplicates(nums, pos + 1, currSum, currList);
        currList.add(nums[pos]);
        threeSum_recur_with_duplicates(nums, pos + 1, currSum + nums[pos], currList);
        currList.remove(currList.size() - 1);
    }


}
