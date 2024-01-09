

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

/*Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5

Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/
public class Kth_Largest_Element_in_UnSorted_Array_215 {

    final Random random = new Random();

    public static void main(String[] args) {
        Kth_Largest_Element_in_UnSorted_Array_215 k = new Kth_Largest_Element_in_UnSorted_Array_215();
//        System.out.println(k.findKthLargest_PQ_Sorting(new int[]{3, 2, 1, 5, 6, 4}, 2)); // 5
//        System.out.println(k.findKthLargest_PQ_Sorting(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4)); // 4

        System.out.println(k.findKthLargest_quicksort1(new int[]{3, 2, 1, 5, 6, 4}, 2)); // 5
        System.out.println(k.findKthLargest_quicksort1(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4)); // 4
        System.out.println(k.findKthLargest_quicksort1(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 9)); // 1

    }

    //O(N lg N) running time + O(1) memory
    public int findKthLargest_arraySorting(int[] nums, int k) {
        Arrays.sort(nums);  //can't reverseorder primitive integers. So copy to Object[] and then reverse.
        Integer[] numsArr = new Integer[nums.length];
        int i = 0;
        for (int value : nums) {
            numsArr[i++] = Integer.valueOf(value);
        }
        Arrays.sort(numsArr, Collections.reverseOrder());  // reverseOrder can be done only on Object arrays not primitive arrays.
        return numsArr[k - 1].intValue();
    }

    //O(k + (n-k)logk) - O(k) for adding k initial elements. Doing at most n-k removals which take O(logk) running time
    // Space- O(K) memory
    public int findKthLargest_PQ_Sorting(int[] nums, int k) {
        //min heap
        final PriorityQueue<Integer> pq = new PriorityQueue<>(); // default ascending order. The first/top element in queue is the smallest number so that it can exit first.
        for (int val : nums) {
            pq.offer(val);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    //The smart approach for this problem is to use the selection algorithm (based on the partion method - the same one as used in quicksort).
    // O(N) best case / O(N^2) worst case running time + O(1) memory
    // If every time pivot ends up to be one edge in each iteration that means we are ending up in solving n + n-1 + n-2 lengths
    // then it becomes n^2 for large input and TLE occurs. To solve that we need to use random pivot so that every time you deal with 20% + 80% length or
    // in best case 50% + 50% length i.e., n + n/2 + n/4 + n/16 ... 1 which is O(2n) ie., O(n)
    public int findKthLargest_quicksort1(int[] nums, int k) {
        return quickSortHelper(nums,  0, nums.length-1, k);
        //return nums[nums.length-k];
    }
    public int quickSortHelper(int[] a, int start, int end, int k){ //need 5 pointers - start, end, pivot (immovable in the iteration once set) and i, j (movable)

      //  int pivot = start;  //choose first element as pivot idx.

       // int pivot = getRandomPivot( a,  start,  end);  //TODO:

        Random random_num = new Random();
        int pivot = start + random_num.nextInt(end - start);

        int j = start - 1;  //j tracks the last seen element that is smaller than pivot (but not necessarily the smallest)

        for(int i = start; i <= end; i++){
            if(a[i] <= a[pivot]){      // remember sometimes j is way behind a large element and i is way ahead but smaller than that larger element then they both have to be swapped.
                int temp = a[j+1];
                a[j+1] = a[i];
                a[i] = temp;
                j++;
            }
        }

        int temp = a[j]; //pivot (which is at the startIdx of arr is now swapped with last seen element (a[j]) that is smaller than pivot)
        a[j] = a[pivot];
        a[pivot] = temp;

        if(a.length - k == j){  //is the "moved" pivot in the kth place
            return a[j];
        }

        if(a.length - k < j) {  // target pos is < j then search on left window of pivot
            return quickSortHelper(a, start, j - 1, k);
        }

        else { // target pos is > j then search on right window of pivot
            return quickSortHelper(a, j + 1, end, k);
        }

    }



    public int findKthLargest_quicksort(int[] nums, int k) {

        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if (j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private int partition(int[] a, int lo, int hi) {

        int i = lo;
        int j = hi + 1;
        while (true) {
            while (i < hi && less(a[++i], a[lo])) ;
            while (j > lo && less(a[lo], a[--j])) ;
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private boolean less(int v, int w) {
        return v < w;
    }


    //    O(N) guaranteed running time + O(1) space
    //    So how can we improve the above quick sort solution and make it O(N) guaranteed?
    // The answer is quite simple, we can randomize the input, so that even when the worst case input would be provided the algorithm wouldn't be affected.
    // So all what it is needed to be done is to shuffle the input.
    public int findKthLargest_Quicksort_Randamoize(int[] nums, int k) {

        shuffle(nums);
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if (j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private void shuffle(int a[]) {

        final Random random = new Random();
        for (int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            exch(a, ind, r);
        }
    }

    private int getRandomPivot(int a[], int start, int end) {

        int r = random.nextInt(end - start) + start;
        return r;
    }

}
