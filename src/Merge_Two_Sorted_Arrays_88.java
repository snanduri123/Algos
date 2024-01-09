import java.util.HashMap;
import java.util.HashSet;

/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.



Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 */
public class Merge_Two_Sorted_Arrays_88 {

    //Time : O(m + n)
    //Space: O(1)
    //Whenever you're trying to solve an array problem in-place, always consider the possibility of iterating backwards
    // instead of forwards through the array. Also use two pointers or three pointers.
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        //since nums1 can hold both nums1 and nums2 elements, and we are writing answer in nums1 array only,
        // use 3 pointers to iterate backwards.
        int i = m - 1, j = n - 1, k = nums1.length - 1;
        while (i >= 0 || j >= 0) {    // "OR" because if nums1 has all greater elements than nums2 then nums1  will be finished (i becomes < 0) but nums2 is still left (j > 0).
            // if there are nums in nums1 and
            // if num in nums1 is greater than nums2 or if nums2 is finished then only move it to k pos - blank spot or it will overwrite in its place.
            // Eg:  int[] nums1 = {1, 3, 5, 7, 0, 0, 0, 0}; int[] nums2 = {2, 4, 6, 8}; //j will be finished eventually and k will be at nums1[0], i will still be at nums1[0] and nums1[0] is overwritten with same value inplace.
            if (i >= 0 && (j < 0 || nums1[i] > nums2[j])) {
                nums1[k--] = nums1[i--];
            } else {                            // if nums1 is finished or nums1 < nums2 then move nums2 to blank spot.
                nums1[k--] = nums2[j--];
            }
        }

        /* if above while is difficult use below while (which is similar to combine step in merge sort)
        while (i >= 0 && j >= 0) {    // "OR" because if nums1 has all greater elements than nums2 then nums1  will be finished (i becomes < 0) but nums2 is still left (j > 0).
            // if there are nums in nums1 and
            // if num in nums1 is greater than nums2 or if nums2 is finished then only move it to k pos - blank spot or it will overwrite in its place.
            // Eg:  int[] nums1 = {1, 3, 5, 7, 0, 0, 0, 0}; int[] nums2 = {2, 4, 6, 8}; //j will be finished eventually and k will be at nums1[0], i will still be at nums1[0] and nums1[0] is overwritten with same value inplace.
            if ( nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {                            // if nums1 is finished or nums1 < nums2 then move nums2 to blank spot.
                nums1[k--] = nums2[j--];
            }
        }

        while (i >= 0) { //if still first array elements are not yet moved.
            nums1[k--] = nums1[i--];
        }

        while (j >= 0) {  //if still first array elements are not yet moved.
            nums1[k--] = nums2[j--];
        }
        */

    }

    //using the basic combine step of merge sort.
    public int[] merge2(int[] nums1, int m, int[] nums2, int n) {

        int[] nums3 = new int[m + n];
        int k = 0;
        int i = 0, j = 0;
        while (i < m && j < n ) {
            if (nums1[i] <= nums2[j]) {
                nums3[k] = nums1[i];
                k++;
                i++;
            } else {
                nums3[k] = nums2[j];
                k++;
                j++;
            }
        }

        while (i < m) {
            nums3[k] = nums1[i];
            k++;
            i++;
        }

        while (j < n) {
            nums3[k] = nums2[j];
            k++;
            j++;
        }

//        for (int num : nums3) {
//            System.out.print(num + "\t");
//        }

        return nums3;
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m -1, j= n-1, k= nums1.length-1;
        while(i>=0 || j >=0){
            if((i < 0 && j >=0) || (nums2[j] > nums1[i])){
                nums1[k] = nums2[j];
                j--;
                k--;
            }else if((j < 0 && i >=0)|| (nums1[i] > nums2[j])){
                nums1[k] = nums1[i];
                i--;
                k--;
            }
        }
    }

    public static void main(String[] args) {

        Merge_Two_Sorted_Arrays_88 m = new Merge_Two_Sorted_Arrays_88();

//        int[] nums01 = {0};  //no self elements for first array
//        int[] nums02 = {1};
//        m.merge(nums01, 0, nums02, 1);
//        m.print(nums01); //1

        int[] nums1 = {1, 3, 5, 7, 0, 0, 0, 0};
        int[] nums2 = {2, 4, 6, 8};
        m.merge(nums1, 4, nums2, 4);
        m.print(nums1); //1	 2	3	4	5	6	7	8

        //i >=0 condition fails  -> nums11 numbers are used up first by writing at the end of nums11 array and nums12 has to be written at the beginning of nums11 array.
        int[] nums11 = {3, 4, 5, 0, 0, 0};
        int[] nums12 = {1, 2, 3};
        m.merge(nums11, 3, nums12, 3);
        m.print(nums11); // 1	2	2	3	5	6

        // first nums8 will be written/used up satisfying j < 0 and then use nums7 numbers.
        int[] nums7 = {1, 2, 3, 4, 5, 0, 0, 0, 0};
        int[] nums8 = {6, 7, 8, 9};
        m.merge(nums7, 5, nums8, 4);
        m.print(nums7); // 1	2	3	4	5  6  7  8	9

        int[] nums3 = {1, 3, 4, 5, 0, 0, 0, 0};
        int[] nums4 = {2, 3, 6, 7};
        m.merge(nums3, 4, nums4, 4);
        m.print(nums3); // 1	2	3	3	4	5	6   7

        int[] nums5 = {1, 3, 4, 5, 8, 0, 0, 0, 0};
        int[] nums6 = {2, 3, 6, 7};
        m.merge(nums5, 5, nums6, 4);
        m.print(nums5); //1  2	 3	 3	 4	 5	 6	 7	 8


        int[] nums9 = {1, 2, 3, 0, 0, 0};
        int[] nums10 = {2, 5, 6};
        m.merge(nums9, 3, nums10, 3);
        m.print(nums9); // 1	2	2	3	5	6

    }

    public void print(int[] nums) {
        System.out.println();
        for (int i : nums) {
            System.out.print(i + "\t");
        }
    }
}
