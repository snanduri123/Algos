/*
Given a 0-indexed integer array nums, return true if it can be made strictly increasing after removing exactly one element, or false otherwise. If the array is already strictly increasing, return true.

The array nums is strictly increasing if nums[i - 1] < nums[i] for each index (1 <= i < nums.length).



Example 1:

Input: nums = [1,2,10,5,7]
Output: true
Explanation: By removing 10 at index 2 from nums, it becomes [1,2,5,7].
[1,2,5,7] is strictly increasing, so return true.
Example 2:

Input: nums = [2,3,1,2]
Output: false
Explanation:
[3,1,2] is the result of removing the element at index 0.
[2,1,2] is the result of removing the element at index 1.
[2,3,2] is the result of removing the element at index 2.
[2,3,1] is the result of removing the element at index 3.
No resulting array is strictly increasing, so return false.
Example 3:

Input: nums = [1,1,1]
Output: false
Explanation: The result of removing any element is [1,1].
[1,1] is not strictly increasing, so return false.


Constraints:

2 <= nums.length <= 1000
1 <= nums[i] <= 1000
 */

public class RemoveOneElementArrayStrictlyIncreasing_1909 {

    //Time : O(n)
    //Space: O(1)
    // input array will be modified.
    public boolean canBeIncreasing(int[] nums) {
        int count = 0;

        if(nums.length <=1)
            return true;

        for(int i = 1; i< nums.length && count < 2; i++) {
            if(nums[i-1] >= nums[i]){  //if prev elem is greater than curr elem then increment count;
                count++;
                if(i > 1 && nums[i-2] >= nums[i]){  // if 2nd prev elem is also greater then increment count
                    nums[i] = nums[i - 1];          // and update the curr elem with that elem so that the next element
                }                                   // can be compared with that 2nd prev elem. Eg: {1,2,10,5,7}
            }                                       // 5 will be overwritten by 2.
        }
        return count < 2;
    }



    public static void main(String[] args){
        RemoveOneElementArrayStrictlyIncreasing_1909 r = new RemoveOneElementArrayStrictlyIncreasing_1909();
        System.out.println(r.canBeIncreasing(new int[] {1,2,10,5,7})); //true. By removing 10 at index 2 from nums, it becomes [1,2,5,7].
        System.out.println(r.canBeIncreasing(new int[] {2,3,1,2})); //false
        System.out.println(r.canBeIncreasing(new int[] {1,1,1})); //false
        System.out.println(r.canBeIncreasing(new int[] {100,21,100})); //true. By removing 100 at index 0.
    }
}
