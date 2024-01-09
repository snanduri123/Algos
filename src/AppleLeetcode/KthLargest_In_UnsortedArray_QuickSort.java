package AppleLeetcode;

public class KthLargest_In_UnsortedArray_QuickSort {
    public int kthLargest(int[] nums, int k) {
        return quickSort(nums, k, 0, nums.length - 1);
    }
    // in best case pivot breaks array into 50% + 50% length i.e., n + n/2 + n/4 + n/16 ... 1 which is O(2n) ie., O(n)
    public int quickSort(int[] nums, int k, int start, int end) { //need 5 pointers - start, end, pivot (immovable in the iteration once set) and i, j (movable)
        int pivot = start;
        int i = start;
        int j = i - 1;
        while( i <= end){
            if(nums[i] <= nums[pivot]){
                int temp = nums[j+1];
                 nums[j+1] = nums[i]; // j is way behind a large element and i is way ahead but smaller than that larger element then they both have to be swapped.
                 nums[i] = temp;
                 j++;
            }
            i++;
        }

        int temp = nums[j];
        nums[j] = nums[pivot];
        nums[pivot] = temp;

        if(j == nums.length - k){
            return nums[j];
        }else if(j < nums.length -k){
           return quickSort(nums, k, j+1, end); //search right window of pivot
        }else{
            return quickSort(nums, k, start, j-1); //search left window of pivot
        }
    }

    public static void main(String[] args) {
        KthLargest_In_UnsortedArray_QuickSort k = new KthLargest_In_UnsortedArray_QuickSort();

      //  System.out.println(k.kthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2)); // 5
        System.out.println(k.kthLargest(new int[]{4, 3, 2, 5, 6, 1}, 2)); // 5
      //  System.out.println(k.kthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4)); // 4
      //  System.out.println(k.kthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 9)); // 1

    }
}
