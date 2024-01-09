/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104
 */

public class BinarySearch_Search_Insert_Position_35 {

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end -start)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(target < nums[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }

    public int searchInsert_Recur(int[] nums, int target) {
        if (nums.length == 0)
            return 0;
        return  binarySearch(nums,  target, 0,  nums.length-1);
    }

    public int binarySearch(int[] nums, int target, int start, int end){
        if(start > end)
            return start;
        int mid = (start + end)/2;   // (start + (end-start)/2)
        if(nums[mid] == target)
            return mid;
        if(target < nums[mid])
            return binarySearch(nums,  target,  start,  end-1);
        return binarySearch(nums,  target,  start + 1,  end);
    }


    public static void main(String[] args){
        BinarySearch_Search_Insert_Position_35 b = new BinarySearch_Search_Insert_Position_35();

        System.out.println(b.searchInsert(new int[]{1,2,3,5}, 4)); //3

//        System.out.println(b.searchInsert(new int[]{1,3,5,6}, 5)); //2
//        System.out.println(b.searchInsert(new int[]{1,3,4,5,6}, 5)); //3
//        System.out.println(b.searchInsert(new int[]{1,3,5,6}, 4)); //2
//        System.out.println(b.searchInsert(new int[]{1,3,4,5,6}, 4)); //2
//        System.out.println(b.searchInsert(new int[]{1,3,5,6}, 7)); //4
//        System.out.println(b.searchInsert(new int[]{2,3,5,6}, 1)); //0
//        System.out.println(b.searchInsert(new int[]{3}, 3)); //0
//        System.out.println(b.searchInsert(new int[]{3}, 1)); //0
//        System.out.println(b.searchInsert(new int[]{3}, 4)); //1

    }

}
