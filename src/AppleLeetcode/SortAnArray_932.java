package AppleLeetcode;

/*
Given an array of integers nums, sort the array in ascending order and return it.

You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.



Example 1:

Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
Example 2:

Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]
Explanation: Note that the values of nums are not necessairly unique.


Constraints:

1 <= nums.length <= 5 * 10^4
-5 * 104 <= nums[i] <= 5 * 10^4
 */

import java.util.Random;

public class SortAnArray_932 {

    public int[] sortArray(int[] nums) {
//        shuffle(nums);
//        mergeSort(nums,  0, nums.length-1);
//        return nums;
        return mergeSort( nums,  0,  nums.length-1);
    }

    public int[] mergeSort(int[] nums, int start, int end){
        //if only one element return that element as new array
        if(start == end)
            return new int[]{nums[start]};

        int mid = start + (end -start)/2;

        //left sorted array and right sorted Array
        int left[] = mergeSort(nums, start , mid);
        int right[] = mergeSort(nums, mid+1, end);

        //merge two arrays
        int[] sorted = new int[left.length + right.length];

        int i=0, j = 0, k =0;

        while( i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                sorted[k] = left[i];
                i++;
                k++;
            } else {
                sorted[k] = right[j];
                j++;
                k++;
            }
        }

        while(i < left.length){
            sorted[k] = left[i];
            i++;
            k++;
        }

        while(j < right.length){
            sorted[k] = right[j];
            j++;
            k++;
        }
        return sorted;
    }

    public int[] sortArray_QuickSort(int[] nums) { //TODO: TLE for large input having same value.
      //  shuffle(nums);  shuffle to randomize the input
        quickSort(nums,  0, nums.length-1);
        return nums;

    }
    public void quickSort(int[] nums, int start, int end){

        if(start >= end)
            return;

        int pivot = start;
        int i = start;
        int j = i -1;

        while(i <= end){
            if(nums[i] <= nums[pivot]){
                int temp = nums[j+1];
                nums[j+1] = nums[i];
                nums[i]= temp;
                j++;
            }
            i++ ;
        }

        int temp = nums[j];
        nums[j] = nums[pivot];
        nums[pivot]= temp;

        quickSort(nums,  start, j-1);
        quickSort( nums, j+1,  end);
    }

    public void shuffle(int[] nums){
        Random r = new Random();
        for(int i=0; i< nums.length-1; i++){
            int idx = r.nextInt(i+1, nums.length);
            int temp = nums[i];
            nums[i] = nums[idx];
            nums[idx] = temp;
        }
    }
}
