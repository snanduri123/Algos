
/* Given an array of integers nums sorted in non-decreasing order,
 find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]


Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109 */

import java.util.Arrays;

public class BinarySearch_Find_Start_End_Pos_34 {

    public static void main(String[] args) {

        BinarySearch_Find_Start_End_Pos_34 b = new BinarySearch_Find_Start_End_Pos_34();

        int[] l1 = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(b.searchRange(l1, 8)));//answer 3,4

        int[] l2 = {8, 8, 8, 8, 8, 8};
        System.out.println(Arrays.toString(b.searchRange(l2, 8)));//answer 0,5

        int[] l3 = {2,4};
        System.out.println(Arrays.toString(b.searchRange(l3, 3)));//answer -1,-1

        int[] l4 = {5, 6, 7, 8, 8, };
        System.out.println(Arrays.toString(b.searchRange(l4, 7)));//answer 2,2

        int[] l5 = {5, 6, 7, 8, 8, 9};
        System.out.println(Arrays.toString(b.searchRange(l5, 7)));//answer 2,2

        int[] l6 = {8};
        System.out.println(Arrays.toString(b.searchRange(l6, 8)));//answer 0,0

        int[] l7 = {};
        System.out.println(Arrays.toString(b.searchRange(l7, 8)));//answer -1,-1

    }

    //Time :O(logn)
    //Space: O(1)
    public int[] searchRange(int[] nums, int target) {
        int start = findLeft( nums,  target);
        int end = findRight( nums,  target);
        return new int[]{start, end};
        //using recursion
        //return new int[] {findLeftMostIdxOfTarget(nums, target, 0,nums.length-1, -1), findRightMostIdxOfTarget(nums, target, 0,nums.length-1, -1)};
    }

    public int findLeft(int[] nums, int target) {
        // left most element which is equal to target
        int left = 0;
        int right = nums.length - 1;
        int leftMost = -1;
        while (left <= right) {
            int mid = (left + right ) / 2;
            if(nums[mid] == target){
                leftMost = mid;   //every time you find target at mid then that is so far left most
                right = mid - 1;  //decrement right to see if there is still leftMost on left side.
            }else if(nums[mid] < target){
                left = mid + 1; //target is on right of mid
            } else{
                right = mid - 1; //target is on left of mid
            }
        }
        return leftMost;
    }
    public int findRight(int[] nums, int target) {
        // right most element which is equal to target
        int left = 0;
        int right = nums.length - 1;
        int rightMost = -1;
        while (left <= right) {
            int mid = (left + right ) / 2;
            if(nums[mid] == target){
                rightMost = mid;  //every time you find target at mid then that is so far right most
                left = mid + 1;  //increment left to see if there is still rightMost on right side.
            }else if(nums[mid] < target){
                left = mid + 1;   //target will be on right of mid
            } else{
                right = mid - 1; //target will be on left of mid
            }
        }
        return rightMost;
    }

    public int findRightMostIdxOfTarget(int[] nums, int target, int start, int end, int lastFoundIdx){
        if(start > end)
            return lastFoundIdx == -1 ?  -1 : start - 1;


        int mid = (start + end)/2;

        if(target >= nums[mid]){
            if(target == nums[mid]){
                lastFoundIdx = mid;
            }
          return  findRightMostIdxOfTarget(nums,  target,  mid + 1,  end, lastFoundIdx);
        }
        else{
          return  findRightMostIdxOfTarget(nums,  target,  start,  mid - 1, lastFoundIdx);
        }
    }

    public int findLeftMostIdxOfTarget(int[] nums, int target, int start, int end, int lastFoundIdx){
        if(start > end)
            return lastFoundIdx == -1 ?  -1 : start;

        int mid = (start + end)/2;

        if(target <= nums[mid]){
            if(target == nums[mid]){
                lastFoundIdx = mid;
            }
            return  findLeftMostIdxOfTarget(nums,  target,  start,  mid - 1, lastFoundIdx);
        }
        else{
            return  findLeftMostIdxOfTarget(nums,  target,  mid + 1,  end, lastFoundIdx);
        }
    }

    //Time : O(n)
    //Space: O(1)
    public int[] searchRange2(int[] nums, int target) {
        int start = -1;
        int end = -1;
        int len=0;
        for(int i=0; i< nums.length; i++){
            if(nums[i] == target){
                len++;
                end = i;
            }
        }
        return (end == -1) ? new int[] {start, end} : new int[] {end - len + 1, end};
    }
}
