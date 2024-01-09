/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]


Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
 */

import java.util.*;

public class Permutation_46 {
    //Time : O(n * n!) Given a set of length n, the number of permutations is n!.
    //  There are n options for the first number, n−1 for the second, and so on.
    //  For each of the n permutations, we need O(n) work to copy curr into the answer. This gives us O(n⋅n!) work.
    //space: O(n) - height of the tree. Each time we create one answer string and need n memory in recursion stack
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        dfs(nums, new ArrayList<>());
        return ans;
    }

    public void dfs(int[] nums, List<Integer> currList){

        if(currList.size() == nums.length){
            List<Integer> list = new ArrayList<>(currList);
            ans.add(list);
            return;
        }

        for(int i=0; i< nums.length;i++){  //i always starts from 0. So choices are always considered from beginning of input.
            if(!currList.contains(nums[i])){  //this search is O(n)
                currList.add(nums[i]);
                dfs(nums, currList);
                currList.remove(currList.size()-1);
            }
        }

    }


    public static void main(String[] args) {
        Permutation_46 n = new Permutation_46();

        int[] nums1 = new int[]{1,2,3};
        System.out.println(Arrays.deepToString(n.permute(nums1).toArray())); //[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]

        int[] nums2 = new int[]{0,1};
        System.out.println(Arrays.deepToString(n.permute(nums2).toArray())); //[[0, 1], [1, 0]]

        int[] nums3 = new int[]{1};
        System.out.println(Arrays.deepToString(n.permute(nums3).toArray())); //[[1]]
    }
}
