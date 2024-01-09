/*
You are given an integer array nums where the largest integer is unique.

Determine whether the largest element in the array is at least twice as much as every other number in the array. If it is, return the index of the largest element, or return -1 otherwise.



Example 1:

Input: nums = [3,6,1,0]
Output: 1
Explanation: 6 is the largest integer.
For every other number in the array x, 6 is at least twice as big as x.
The index of value 6 is 1, so we return 1.
Example 2:

Input: nums = [1,2,3,4]
Output: -1
Explanation: 4 is less than twice the value of 3, so we return -1.


Constraints:

2 <= nums.length <= 50
0 <= nums[i] <= 100
The largest element in nums is unique.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestNumberAtLeastTwiceOfOthers_747 {

    //Time(bad): n * n (every num element checks for other elements in map (double for loop)
    //Space: O(n)
    public int dominantIndex3(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, num * 2);
        }

        for (int i = 0; i < nums.length; ++i) {
            boolean isTwice = true;
            for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
                if (pair.getKey() != nums[i]) {
                    if (nums[i] < pair.getValue()) {
                        isTwice = false;
                        break;
                    }
                }
            }

            if (isTwice)
                return i;
        }
        return -1;
    }


    //Time:  O(n) + O(nlogn)
    //Space: O(n)
    public int dominantIndex2(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        Arrays.sort(nums);


        if (nums[nums.length - 1] >= nums[nums.length - 2] * 2) {
            return map.get(nums[nums.length - 1]);
        }
        return-1;
}


    //Time: O(n)
    //Space: O(1)
    public int dominantIndex(int[] nums) {

        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        int firstLargestIdx=-1;

        for(int i =0; i<nums.length; i++){
            if(nums[i] > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = nums[i];
                firstLargestIdx = i;

            }
            if(nums[i] > secondLargest && nums[i] < firstLargest ){
                secondLargest = nums[i];
            }
        }

        if(firstLargest >= secondLargest * 2){
            return firstLargestIdx;
        }

        return -1;

    }

    public static void main(String[] args) {
        LargestNumberAtLeastTwiceOfOthers_747 l = new LargestNumberAtLeastTwiceOfOthers_747();
        System.out.println(l.dominantIndex(new int[] {1,2,3,4})); //-1
        System.out.println(l.dominantIndex(new int[]{3, 6, 1, 0})); //1 (6)
        System.out.println(l.dominantIndex(new int[]{-3, -4, -1, -2})); //2 (1)
    }
}
