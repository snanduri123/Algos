/*(Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

*/

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    //Time complexity - O(n)
    //Space complexity - O(n) // if space complexity has to be decreased the we have to use binarysearch which increases time complexity.
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();

        for(int i = 0; i< nums.length; i++){
            int complement = target - nums[i]; //
            if(!numMap.containsKey(complement)){
                numMap.put(nums[i], i); // Map maintains the input number and its index
            }
            else {
                return new int[]{numMap.get(complement), i};  // as soon as one pair is found return indexes of both numbers. No need to search more.
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum t = new TwoSum();
        System.out.println(Arrays.toString(t.twoSum(new int[] {2,7,11,15}, 9))); // [1,0]
    }

}
