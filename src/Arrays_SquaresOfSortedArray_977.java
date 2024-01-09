/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.



Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]


Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
 */

import java.util.Arrays;

public class Arrays_SquaresOfSortedArray_977 {

    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];

        //use left and right pointers to compare the numbers.
        //use index pointer i in reverse order to fill the answer array in reverse order.
        for(int i = nums.length-1, left = 0, right = nums.length-1 ; i >= 0 ; i--){

            int num = 0;

            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                num = nums[left];
                left++;
            }
            else{
                num = nums[right];
                right--;
            }
            ans[i] = num * num;
        }
        return ans;
    }

    public static void main(String[] args) {

        Arrays_SquaresOfSortedArray_977 s= new Arrays_SquaresOfSortedArray_977();

        int[] nums1 = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(s.sortedSquares(nums1))); // [16,1,0,9,100]

//        int[] nums2 = {-7,-3,2,3,11};
//        System.out.println(Arrays.toString(s.sortedSquares(nums2))); // [4,9,9,49,121]
//
//        int[] nums3 = {-10,-1,0,3,8};
//        System.out.println(Arrays.toString(s.sortedSquares(nums3))); // [1,0,9,64,100]
    }
}
