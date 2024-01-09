/*
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1


Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104
 */


import java.util.Arrays;

public class BinarySearch_Rotated_Sorted_Array_33 {

    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {  //uptil 2 or 1 element do check.
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[start] <= nums[mid]) { // left to MID is sorted Eg: [4,5,6,1,2,3] or [3,1] - 3 to 3 is sorted on left side.
                if (target >= nums[start] && target < nums[mid] ) { //is it in the left range
                    end = mid-1;
                } else {  //target is in right side
                    start = mid + 1;
                }
            } else {  //if left is not sorted  Eg: 4,5,1,2,3 or no more elements on left side Eg: [1,3]
                if (target > nums[mid] && target <= nums[end]) { //target is in right range
                    start = mid + 1;
                } else{
                    end = mid - 1; //target is on left side. Eg: 6,5,4,3,2,1,0, target = 4
                }
            }
        }

        return (start > end) ? -1 : nums[start];  //Eg: [3,1], start will be
        //return (nums[start] == target) ? start : -1; //use this statement if while(start < end)
    }

    public static void main(String[] args) {

        BinarySearch_Rotated_Sorted_Array_33 b = new BinarySearch_Rotated_Sorted_Array_33();

//        int[] l1 = {4,5,6,7,0,1,2};  //odd, target on right side of mid
//        System.out.println(b.search(l1, 0));//4
//
//        int[] l2 = {4,5,6,7,0,1,2}; //odd, target on left side of mid
//        System.out.println(b.search(l2, 5));//1
//
//        int[] l3 = {4,5,6,0,1,2}; //even, target on right side of mid
//        System.out.println(b.search(l3, 1));//4
//
//        int[] l4 = {4,5,6,0,1,2}; //even, target on left side of mid
//        System.out.println(b.search(l4, 5));//1
//
//
//        int[] l5 = {4,5,6,7,0,1,2};  //odd, target is mid
//        System.out.println(b.search(l5, 0));//4
//
//        int[] l6 = {4,5,6,0,1,2}; //even, target is mid
//        System.out.println(b.search(l6, 0));//3
//
//        int[] l7 = {4,5,6,3,2,1,0}; //even, target is middish
//        System.out.println(b.search(l7, 6));//2
//
//        int[] l8 = {1,3}; //target missing
//        System.out.println(b.search(l8, 2));//-1

        int[] l9 = {3,1}; //start > end, so return start  **************
        System.out.println(b.search(l9, 1));//1

//        int[] l10 = {4,5,6,7,8,1,2,3};  //odd, target is greater than mid and on right side
//        System.out.println(b.search(l10, 8));//4

    }
}
