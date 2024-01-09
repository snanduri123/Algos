/*
A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.



Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.


Constraints:

1 <= nums.length <= 1000
-231 <= nums[i] <= 231 - 1
nums[i] != nums[i + 1] for all valid i.
 */
public class BinarySearch_PeakElement_162 {
    public int findPeakElement(int[] nums) { //same as peakIndexMountainArray_852 problem.
        int start = 0;
        int end = nums.length-1;
        while(start + 1 < end){  //have at least 3 elements for checking. coming out of the loop may contain 2
            int mid = start + (end-start)/2;
//            if((nums[mid-1] < nums[mid]) && (nums[mid] > nums[mid+1])){ //optional
//                return mid;
//            }
            if(nums[mid+1] > nums[mid]){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        //if input has 1 element then it will be both start and end, so return either of them. Per below return statement end is returned.
        //if input has 2 element then check which is greater and then return it.
        return (nums[start] > nums[end]) ? start : end;
    }

    public int findPeakElement2(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start < end){    //has at least 2 elements. out of loop will come to 1 element
            int mid = start + (end - start)/2;
            if(nums[mid] > nums[mid+1]){ //if mid > mid+1 then INCLUDE mid for search on left half
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        //  0 1
        // Eg:1 [1,2] - mid is 0, nums[0] < nums[1], so start becomes mid + 1 (in while loop). Now start = 1, end is still 1.
        //      while condition fails (not having 2 elements to check) and comes here.
        //      so 1 element to check and start is already pointing to it, so return start.
        // Eg:2 [2,1] = mid is 0, nums[0] > nums[1], so end becomes mid (in while loop). Now start is still 0 and end = 0.
        //      while condition fails (not having 2 elements to check) and comes here.
        //      so 1 element to check and start is already pointing to it, so return start.
        return start;
    }

    public static void main(String[] args){
        BinarySearch_PeakElement_162 p = new BinarySearch_PeakElement_162();
        System.out.println(p.findPeakElement(new int[]{1,2,3,1})); //2
        System.out.println(p.findPeakElement(new int[]{1,2,1,3,5,6,4}));//5
        System.out.println(p.findPeakElement(new int[]{1})); //0
        System.out.println(p.findPeakElement(new int[]{2,1})); //0
    }
}
