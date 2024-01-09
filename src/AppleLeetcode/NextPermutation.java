package AppleLeetcode;/*
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer.
More formally, if all the permutations of the array are sorted in one container according to their lexicographical order,
then the next permutation of that array is the permutation that follows it in the sorted container.
If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.



Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]


Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100
 */

import java.util.Arrays;
import java.util.Stack;

public class NextPermutation {


    //Time: O(nlogn)  = n (for loop) +logn(sorting)
    //space: O(n) - stack worst case may need size of n (Eg: 123. -> can't swap so everything end up in stack)
    public void nextPermutation(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int i = nums.length - 1; //iterate BACKWARDS
        while(i>=0){
            if(stack.isEmpty() || nums[i] >= nums[stack.peek()]){  //if empty stack or if current number is greater then it goes on to stack
                stack.add(i);// Store INDEX only
                i--;
            }else{ //some number IN BETWEEN array is smaller than previously looked numbers
                int leastBigNumberIdx = i; // find the element in the stack that is the least bigger than the current number
                while(!stack.isEmpty() && nums[i] < nums[stack.peek()]){
                    leastBigNumberIdx = stack.pop();
                }
                //swap the numbers
                int temp = nums[leastBigNumberIdx];
                nums[leastBigNumberIdx] = nums[i];
                nums[i] = temp;
                break;
            }
        }
       Arrays.sort(nums, i+1, nums.length);//either i would have become 0 (bcoz of i--) or you have done swapping
        // with bigger element, so rest of the digits to right side of current idx should all be sorted in ascending order.
    }


    public static void main(String[] args){
        NextPermutation n = new NextPermutation();

        int[] nums = new int[]{6,3,5,4,2,1}; // 9 and 7 will be swapped and then 7,6,3 will be sorted to get the next bigger permutation
        n.nextPermutation(nums);                                  //(swap 3&4)            (sort 5to1 ascending)
        System.out.println(Arrays.toString(nums)); // [6,3,5,4,2,1] ---------->[6,4,5,3,2,1] ----> [6,4,1,2,3,5]

        int[] nums1 = new int[]{8,7,9,6,3}; // 9 and 7 will be swapped and then 7,6,3 will be sorted to get the next bigger permutation
        n.nextPermutation(nums1);
        System.out.println(Arrays.toString(nums1)); // [8, 9, 3, 6, 7]

        int[] nums2 = new int[]{8,7,6};  // if given number is already highest then next permutation will be the least
        n.nextPermutation(nums2);
        System.out.println(Arrays.toString(nums2)); // [6,7,8]

        int[] nums3 = new int[]{1,3,2};  // *** all the indeces have to swap.
        n.nextPermutation(nums3);
        System.out.println(Arrays.toString(nums3)); // [2,1,3]

    }
}
