package Sorting;

import java.util.Arrays;

public class QuickSorting {

    //Time Complexity : avg case : O(nlogn), worstcase : O(n^2);
    //Space Complexity: O(1) (no extra  memory is used)
    public void quickSort(int[] a){
        //shuffle(a);  //randomize input, so even the worst case input (having to split at every index for pivot) becomes randomized so that you do not end up splitting at every idx.
        quickSortHelper(a,  0, a.length-1);
    }

    /* 5 pointers,
     pivot (start to end)
     i (iterator from start to end)
     j (last index where element is smaller than pivot)
     start
     end
     */
    public void quickSortHelper(int[] a, int start, int end){

        if(start >= end)
            return;

        int pivot = start;  //choose first element as pivot idx.
        int j = start - 1;  //j tracks the last seen element that is smaller than pivot (but not necessarily the smallest)

        for(int i = start; i <= end; i++){
            /*
            //if ith val <= pivotVal then it should be the last seen element that is smaller than pivot,
            // that means it should be at j+1.
            // So swap ithVal to j+1 position and j+1th val to ith position.
            // a =  7 4 0 8 -10 14 3
            //
            // 1.    i = 0, pivot = 0
            //       j = -1
            //     a[i] <= a[pivot] => a[0] <= a[0] => 7 <= 7
            //     j+1 = 1 and a[j+1] = 7.
            //  Swap a[i] and a[j+1] => 7 swaps with 7.
            //  Increment j to 0, because now last element seen that is smaller than pivot is 7 and updated at j+1 position.
            //     a = 7 4 0 8 -10 14 3
            //
            // 2.   i=1,  pivot =0
            //      j = 1
            //     a[i] <= a[pivot] => a[1] <= a[0] => 4 <= 7
            //     j+1 = 1 and a[j+1] = 4.
            //  Swap a[i] and a[j+1] => 4 swaps with 4.
            //  Increment j to 1, because now last element seen that is smaller than pivot is 4 and updated at j+1 index = 1.
            //     a = 7 4 0 8 -10 14 3
            //
            // 3.  For i= 2 also it will be similar
            //     j is incremented to 2, a = 7 4 0 8 -10 14 3
            //
            // 4.   i=3,  pivot =0
            //      j = 2
            //     a[i] <= a[pivot] => 8 <= 7  => false
            //     Since the condition failed, no swapping.
            //     j remains to be 2.
            //     a = 7 4 0 8 -10 14 3
            //
            // 5.   i=4,  pivot =0
            //      j = 2
            //     a[i] <= a[pivot] => a[4] <= a[0] => -10 <= 7
            //     j+1 = 3 and a[3] = 8.
            //  Swap a[i] and a[j+1] => -10 swaps with 8
            //  Increment j to 3, because now last element seen that is smaller than pivot is -10 and updated at j+1 index = 3.
            //     a = 7 4 0 -10 8 14 3
            //
            // 6. When i= 5
            //     14 > 7 so no changes in the array and j
            // 7. Finally when i = 6,
            //    j is still 3
            //    6 is swapped with 8 ( a[j+1] = a[4] = 8 ) and j is incremented to 4.
            //    a = 7 4 0 -10 3 14 8
            */
            if(a[i] <= a[pivot]){
                int temp = a[j+1];
                a[j+1] = a[i];
                a[i] = temp;
                j++;
            }
        }

        /*
        // Now because one iteration is done, now we swap pivot position with j+1 position,
        // i.e, j+1 = 5 and pivot value is moved to a[5].
        // So with this we know all elements left to a[5] (=7) are smaller than 7 but they may not have been sorted yet.
        //     and similarly elements on right side are greater than 7.
        //   So at the end of iteration, the pivot 7 is placed in the correct position and it does not have to be touched.
        // only left and right part are touched/ sorted in recursion.
        // Now sort those two sub arrays in recursion.
        */

        int pivotSwapToIdxVal = a[j]; //pivot (which is at the startIdx of arr is now swapped with last seen element (a[j]) that is smaller than pivot)
        a[j] = a[pivot];
        a[pivot] = pivotSwapToIdxVal;

        quickSortHelper(a,  start, j-1);
        quickSortHelper(a,  j+1, end);
    }

    public static void main(String[] args){
        QuickSorting q = new QuickSorting();

        int[] a = new int[] {7,4,0,8,-10,14,3};
        q.quickSort(a);
        System.out.println(Arrays.toString(a));
    }

}
