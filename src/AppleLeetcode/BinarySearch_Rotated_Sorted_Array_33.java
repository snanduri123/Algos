package AppleLeetcode;

public class BinarySearch_Rotated_Sorted_Array_33 {

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {   //uptil 2 or 1 element do check.
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[start] <= nums[mid]) {  //left is sorted
                if (nums[start] <= target && target < nums[mid]) { // target is in between start and mid - 1
                    end = mid - 1;
                } else {  // target is in right half  Eg: 1 in 23451
                    start = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[end]) {  // target is in between mid + 1 and end
                    start = mid + 1;
                } else {  // target is in left half Eg: 6 in  561234
                    end = mid - 1;
                }
            }
        }
        return -1;  //Two cases: Eg1: find 1 in [3,1] - start = 1, end=0. Eg2: find 2 in [1,3] - start = 0, end= -1
    }

    public static void main(String[] args) {

        BinarySearch_Rotated_Sorted_Array_33 b = new BinarySearch_Rotated_Sorted_Array_33();

        int[] l1 = {4,5,6,7,0,1,2};  //odd, target on right side of mid
        System.out.println(b.search(l1, 0));//4

        int[] l2 = {4,5,6,7,0,1,2}; //odd, target on left side of mid
        System.out.println(b.search(l2, 5));//1

        int[] l3 = {4,5,6,0,1,2}; //even, target on right side of mid
        System.out.println(b.search(l3, 1));//4

        int[] l4 = {4,5,6,0,1,2}; //even, target on left side of mid
        System.out.println(b.search(l4, 5));//1


        int[] l5 = {4,5,6,7,0,1,2};  //odd, target is mid
        System.out.println(b.search(l5, 0));//4

        int[] l6 = {4,5,6,0,1,2}; //even, target is mid
        System.out.println(b.search(l6, 0));//3

        int[] l7 = {4,5,6,3,2,1,0}; //even, target is middish
        System.out.println(b.search(l7, 6));//2

        int[] l8 = {1,3}; //target missing
        System.out.println(b.search(l8, 2));//-1

        int[] l9 = {3,1}; //start > end, so return start  **************
        System.out.println(b.search(l9, 1));//1

        int[] l10 = {4,5,6,7,8,1,2,3};  //odd, target is greater than mid and on right side
        System.out.println(b.search(l10, 8));//4

    }
}
