import java.util.*;

/*
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.



Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false


Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105
 */
public class ArrayContainsDuplicate2 {

    //Time Complexity : O(n)
    //Space complexity : K

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                for (Integer idx : map.get(nums[i])) {
                    if (i - idx <= k)
                        return true;
                }
                map.get(nums[i]).add(i);
                map.put(nums[i], map.get(nums[i]));
            } else {
                map.put(nums[i], new ArrayList<Integer>(Arrays.asList(i)));

            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayContainsDuplicate2 a = new ArrayContainsDuplicate2();
        System.out.println(a.containsNearbyDuplicate(new int[]{1,2,3,1}, 3)); //true
        System.out.println(a.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1)); //true
        System.out.println(a.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2)); //false
        System.out.println(a.containsNearbyDuplicate(new int[]{99,99}, 2)); //true
    }
}
