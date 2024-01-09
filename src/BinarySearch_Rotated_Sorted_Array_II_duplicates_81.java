/*
There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

You must decrease the overall operation steps as much as possible.



Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false


Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
nums is guaranteed to be rotated at some pivot.
-104 <= target <= 104


Follow up: This problem is similar to Search in Rotated Sorted Array, but nums may contain duplicates. Would this affect the runtime complexity? How and why?
 */

public class BinarySearch_Rotated_Sorted_Array_II_duplicates_81 {

    //Time : O(n) - worst case (if no duplicates then it will be O(logn))
    //Space: O(1)
    public boolean search(int[] nums, int target) {
        int start =0;
        int end = nums.length - 1;
        while(start <= end){
            while(start < end && nums[start]==nums[start + 1]){ //skip left duplicates
                start++;
            }
            while(start < end && nums[end]==nums[end - 1]){ //skip right duplicates
                end--;
            }
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[start] <= nums[mid]){
                if(nums[start] <= target && target < nums[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{
                if(nums[mid] < target && target <= nums[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        BinarySearch_Rotated_Sorted_Array_II_duplicates_81 b = new BinarySearch_Rotated_Sorted_Array_II_duplicates_81();

        int[] l1 = {2,5,6,0,0,1,2};  //
        System.out.println(b.search(l1, 0));//true

        int[] l2 = {2,5,6,0,0,1,2}; //odd, target on left side of mid
        System.out.println(b.search(l2, 3));//false

        int[] l3 = {1,0,1,1,1}; //even, target on right side of mid
        System.out.println(b.search(l3, 0));//true
    }
}
