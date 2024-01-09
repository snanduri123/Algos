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

public class BinarySearch_Rotated_Sorted_Array_FindMin_153 {

    public int findMin(int[] nums) {
        int start = 0, end = nums.length-1;
        int smallest = Integer.MAX_VALUE;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid] >= nums[start]){
                smallest = Math.min(nums[start],smallest);
                start = mid+1;
            }else{
                smallest = Math.min(nums[mid],smallest);
                end = mid - 1;
            }
        }
        return smallest;
    }

    public int findMin2(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
            int mid = start + (end-start)/2;
            if(nums[mid] < nums[end]){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return nums[start];
    }



    public static void main(String[] args) {

        BinarySearch_Rotated_Sorted_Array_FindMin_153 b = new BinarySearch_Rotated_Sorted_Array_FindMin_153();

        int[] l1 = {1,2,3,4,5,6,7};  //odd, target on right side of mid
        System.out.println(b.findMin(l1));//4

        int[] l2 = {7,1,2,3,4,5,6}; //odd, target on left side of mid
        System.out.println(b.findMin(l2));//1

        int[] l3 = {6,7,1,2,3,4,5}; //even, target on right side of mid
        System.out.println(b.findMin(l3));//4

        int[] l4 = {5,6,7,1,2,3,4}; //even, target on left side of mid
        System.out.println(b.findMin(l4));//1

        int[] l5 = {4,5,6,7,1,2,3};  //odd, target is mid
        System.out.println(b.findMin(l5));//4

        int[] l6 = {3,4,5,6,7,1,2}; //even, target is mid
        System.out.println(b.findMin(l6));//3

        int[] l7 = {2,3,4,5,6,7,1}; //even, target is middish
        System.out.println(b.findMin(l7));//2
    }
}
