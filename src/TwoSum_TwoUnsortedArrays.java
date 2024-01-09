/*
Given two unsorted arrays of distinct elements, the task is to find all pairs from both arrays whose sum is equal to X.

Examples:

Input :  arr1[] = {-1, -2, 4, -6, 5, 7}
         arr2[] = {6, 3, 4, 0}
         x = 8
Output : 4 4
         5 3
Input : arr1[] = {1, 2, 4, 5, 7}
        arr2[] = {5, 6, 3, 4, 8}
        x = 9
Output : 1 8
         4 5
         5 4
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSum_TwoUnsortedArrays {

    //Time complexity - O(n)
    //Space complexity - O(n) // if space complexity has to be decreased then we have to use binary search which increases time complexity.
    public List<Integer[]> twoSum(int[] nums1, int[] nums2, int target) {

        List<Integer[]> ans = new ArrayList<>();
        HashMap<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            numMap.put(nums1[i], i); // Map maintains the input number and its index
        }

        for (int i = 0; i < nums2.length; i++) {
            int complement = target - nums2[i]; //
            if (numMap.containsKey(complement)) {
               ans.add(new Integer[]{complement, nums2[i]});
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TwoSum_TwoUnsortedArrays t = new TwoSum_TwoUnsortedArrays();
        System.out.println(Arrays.deepToString(t.twoSum(new int[]{1, 0, -4, 7, 6, 4}, new int[] {0, 2, 4, -3, 2, 1}, 8).toArray())); // [1,0]
    }

}
