/*
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.



Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]


Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105


Follow up:

Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?
 */

import java.util.Arrays;

public class RotateArray_189 {
    public int[] rotate2(int[] nums, int k) {
        int i = 0;
        if(k==0 || k % nums.length == 0)
            return nums;

        k = k % nums.length;

        while (i < nums.length - k) {
            int j = nums.length - k;
            int count = 0;
            while (count < k) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
                count++;
            }
        }
        return nums;
    }

    public int[] rotate(int[] nums, int k) {
        reverse(nums, 0, nums.length -1);  //reverse all elements             7 6 5 4 3 2 1
        reverse(nums, 0, k-1);  // reverse starting k (0 to k -1) elements.  5 6 7 4 3 2 1
        reverse(nums, k, nums.length - 1); //reverse rest of the elements.    5 6 7 1 2 3 4
        return nums;
    }

    public void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        RotateArray_189 r = new RotateArray_189();
        System.out.println(Arrays.toString(r.rotate(new int[]{1}, 0)));
        System.out.println(Arrays.toString(r.rotate(new int[]{1}, 1)));
        System.out.println(Arrays.toString(r.rotate(new int[]{1}, 2)));
//        System.out.println(Arrays.toString(r.rotate(new int[]{1,2}, 3)));
//        System.out.println(Arrays.toString(r.rotate(new int[]{1,2,3}, 3)));
//        System.out.println(Arrays.toString(r.rotate(new int[]{1,2,3,4,5,6,7}, 3)));
//        System.out.println(Arrays.toString(r.rotate(new int[]{1,2,3,4,5,6,7,8,9}, 3)));
//        System.out.println(Arrays.toString(r.rotate(new int[]{1,2,3,4,5,6,7,8,9,10,11,12}, 3)));
//        System.out.println(Arrays.toString(r.rotate(new int[]{-1,-100,3,99}, 2)));
//        System.out.println(Arrays.toString(r.rotate(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27}, 38)));
    }
}
