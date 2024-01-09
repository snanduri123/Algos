/*
Given an array of integers nums, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.



Example 1:

Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The pivot index is 3.
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11
Example 2:

Input: nums = [1,2,3]
Output: -1
Explanation:
There is no index that satisfies the conditions in the problem statement.
Example 3:

Input: nums = [2,1,-1]
Output: 0
Explanation:
The pivot index is 0.
Left sum = 0 (no elements to the left of index 0)
Right sum = nums[1] + nums[2] = 1 + -1 = 0


Constraints:

1 <= nums.length <= 104
-1000 <= nums[i] <= 1000
 */

public class Find_Pivot_Index_724 {


    //Time: O(n) +O(n) = O(n)
    //Space: O(1)
    public int pivotIndex(int[] nums) {

      int sum=0;
      int leftSum = 0;

      for(int num: nums){  //find total sum
          sum +=num;
      }

      //If there is pivot, rightSum = leftSum
      //leftSum(or rightSum) = TotalSum - leftSum - pivotIdxVal

      for(int idx=0; idx<nums.length; idx++){  //every idx is checked if it is pivot.
          if(leftSum == sum - leftSum - nums[idx])
              return idx;
          leftSum += nums[idx];
      }
      return -1;
    }



    public static void main(String[] args){
        Find_Pivot_Index_724 f = new Find_Pivot_Index_724();
        System.out.println(f.pivotIndex(new int[]{1,7,3,6,5,6})); //3 - 6 at pos 3 is pivot
        System.out.println(f.pivotIndex(new int[]{1,2,3})); // -1
        System.out.println(f.pivotIndex(new int[]{2,1,-1})); // 0
    }
}
