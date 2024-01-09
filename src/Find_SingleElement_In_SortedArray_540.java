/*
ou are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.



Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10


Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 105
 */

public class Find_SingleElement_In_SortedArray_540 {

    public int singleNonDuplicate(int[] nums) {
        int start =0;
        int end = nums.length-1;
        while(start + 1 < end){  //there is only one answer, so we maintain min of 3 numbers in search area.
            int mid = start + (end-start)/2;

            if(nums[mid] == nums[mid-1]){  //if mid and mid - 1 are equal
                int leftlen = (mid-1) - start;   //find left length
                if(leftlen %2 == 0){   //if left length is even then search on right side
                    start = mid + 1;
                }else{      //search on left side (if left len is odd)
                    end = mid - 2;
                }
            }else if(nums[mid] == nums[mid+1]){ //if mid and mid - 1 are equal
                int rightlen = end - mid + 1;  //find right length
                if(rightlen %2 == 0){  //if right length is even then search on left side
                    end = mid - 1;
                }else{   //if right length is odd then search on right side
                    start = mid + 2;
                }
            }else{
                return nums[mid];  //if mid has no duplicate on either sides then mid is alone and is answer.
            }
        }

        return nums[start]; //you reach to a point where there is only one element in the search array.
    }

    public static void main(String[] args){
        Find_SingleElement_In_SortedArray_540 f = new Find_SingleElement_In_SortedArray_540();

        System.out.println(f.singleNonDuplicate(new int[] {1,1,2,3,3,4,4,8,8})); //2
        System.out.println(f.singleNonDuplicate(new int[] {3,3,7,7,10,11,11})); //10
        System.out.println(f.singleNonDuplicate(new int[] {1})); //1
    }
}
