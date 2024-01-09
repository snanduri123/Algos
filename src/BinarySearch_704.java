/*
Given an array of integers nums which is sorted in ascending order, and an integer target,
 write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1


Constraints:

1 <= nums.length <= 104
-104 < nums[i], target < 104
All the integers in nums are unique.
nums is sorted in ascending order.
 */

public class BinarySearch_704 {

    //Time: O(logn)
    //space: O(1)
    public int search(int[] nums, int target) {
        return binarySearch(nums,  target, 0, nums.length-1);
    }

    public int binarySearch1(int[] nums, int target, int start, int end) { //recursion

        if(start > end){
            return -1;
        }

        int mid = (start + end)/2;  //int mid = start + (end - start) / 2;

        if(target == nums[mid])
            return mid;

        if(target > nums[mid])
            return binarySearch(nums, target, mid+1, end);
        else
            return binarySearch(nums, target, start, mid-1);

    }

    public int binarySearch(int[] nums, int target, int start, int end) { //iteration

        while(start <= end) {
            int mid = start + (end-start)/2;
            if(target == nums[mid]){
                return mid;
            }
            if(target < nums[mid]) {
                end = mid -1;
            }else{
                start = mid + 1;
            }
        }
        return (nums[start] == target) ? start : -1;
    }

    public static void main(String[] args) {

        BinarySearch_704 b = new BinarySearch_704();
        System.out.println(b.search(new int[]{1,2,3}, 3)); // 2
        System.out.println(b.search(new int[]{1,2,4}, 3)); // -1  (start becomes > end)
        System.out.println(b.search(new int[]{1,2,3,5}, 4)); // -1 (end becomes < start)
        System.out.println(b.search(new int[]{-1,0,3,5,9,12}, 9)); // 4
        System.out.println(b.search(new int[]{-1,0,3,5,9,12}, 0)); // 1
        System.out.println(b.search(new int[]{1,2,2,3}, 2)); // 1 or 2 (any occurrence (whichever encountered first) is returned in case of duplicates - not relevant test for this problem as per constraint)


    }
}
