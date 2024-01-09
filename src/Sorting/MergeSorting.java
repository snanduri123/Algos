package Sorting;

import java.util.Arrays;

public class MergeSorting {

   public int[] mergeSort(int[] arr){
       return mergeSortHelper(arr,  0,  arr.length-1);
   }

   //Time : O(nlogn) -- > If there are 8 elements there will be 3 levels (for 16 there will be 4 levels) to become 1.
    //                    because at every level there are 2 sub problems by diving it into half (n/2)
    //                    log 8 = log 2^3 = 3
   //                    In every element you might end up (in worst case) arranging/solving/sorting n elements, so nlogn.
    //Space: O(n)
    public int[] mergeSortHelper(int[] arr, int start, int end){
        if(start == end){
            return new int[]{arr[start]};
        }
        //divide
        int mid = (start + end)/2;
        int[] left = mergeSortHelper(arr, start, mid);
        int[] right = mergeSortHelper(arr, mid+1, end);
        //combine -
        int i = 0;
        int j = 0;
        int[] sortedArr = new int[left.length+right.length]; //initialize an auxillary array
        int k = 0;
        while( i < left.length &&  j < right.length){
            if(left[i] > right[j]) {
                sortedArr[k] = right[j];
                j++;
            } else {
                sortedArr[k] = left[i];
                i++;
            }
            k++;
        }
        while(i < left.length){  //if there are still elements left in left array add to the combinedSortedArray.
            sortedArr[k] = left[i];
            i++;
            k++;
        }
        while(j <right.length){ //if there are still elements left in right array add to the combinedSortedArray.
            sortedArr[k] = right[j];
            j++;
            k++;
        }
        return sortedArr;
    }

    public static void main(String[] args){
        MergeSorting m = new MergeSorting();
        System.out.println(Arrays. toString(m.mergeSort(new int[] {6,4,3,2,7,1,5,8})));
        System.out.println(Arrays. toString(m.mergeSort(new int[] {6,4,3,2,7,1,5})));
        System.out.println(Arrays. toString(m.mergeSort(new int[] {8,7,6,5,4,3,2,1})));
    }
}
