/*
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.



Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]


Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10
 */

import java.util.*;

public class Permutation_with_Duplicates_II_47 {


    //Time:
    //space:
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> result = new ArrayList<>();
        dfs(map, new ArrayList<>(), result, nums.length);
        return result;
    }

    private void dfs(Map<Integer, Integer> map, List<Integer> currList, List<List<Integer>> result, int size) {
        if (currList.size() == size) {
            result.add(new ArrayList<>(currList));
            return;
        }
        for (int key : map.keySet()) { // the choice comes from the hashmap keys.
            if (map.get(key) > 0) {
                currList.add(key);
                map.put(key, map.get(key) - 1); //decrement the counter
                dfs(map, currList, result, size);
                currList.remove(currList.size() - 1); //remove from list
                map.put(key, map.get(key) + 1); //increment or putback the counter
            }
        }
    }


    public static void main(String[] args) {
        Permutation_with_Duplicates_II_47 n = new Permutation_with_Duplicates_II_47();

        int[] nums1 = new int[]{1,1,2};
        System.out.println(Arrays.deepToString(n.permuteUnique(nums1).toArray())); //[[1, 1, 2], [1, 2, 1], [2, 1, 1]]

        int[] nums2 = new int[]{1,2,3};
        System.out.println(Arrays.deepToString(n.permuteUnique(nums2).toArray())); //[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

        int[] nums3  = new int[]{1,1,2,2};
        System.out.println(Arrays.deepToString(n.permuteUnique(nums3).toArray())); //[[1, 1, 2], [1, 2, 1], [2, 1, 1]]
    }
}
