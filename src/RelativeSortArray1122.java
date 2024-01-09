/*
Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.



Example 1:

Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]
Example 2:

Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
Output: [22,28,8,6,17,44]


Constraints:

1 <= arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
All the elements of arr2 are distinct.
Each arr2[i] is in arr1.
 */

import java.util.Arrays;

public class RelativeSortArray1122 {


    //Time : O(n)
    //Space: O(k). 1000 constant space array is used.
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cnt = new int[1001];

        //track the count for each unique element of arr1
        for( int i=0; i< arr1.length; i++){
            cnt[arr1[i]]++;
        }

        //update arr1 itself with the each element of arr2 (common with arr1)and its occurance
        int idx=0;
        for(int i=0; i<arr2.length;i++){
            int count = cnt[arr2[i]];
            int freq =0;

            while(freq < count){
                arr1[idx] = arr2[i];
                idx++;
                freq++;
            }

            cnt[arr2[i]] = 0;
        }

        //arr1's non common elements with arr2, also have to be added back to arr1.
        for(int i=0; i< cnt.length; i++){
            while(cnt[i] >0){
                arr1[idx] = i;
                cnt[i]--;
                idx++;
            }
        }
        return arr1;
    }

        //Time : n^2
    //Space: O(1). In place sorted.
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {


        int i=0,j=0; // i pointer for each idx in arr1. j pointer to traverse arr1 and check if the value is same as in arr2.
        int k=0; // pointer for arr2.

        while( k < arr2.length) {   //for every element in arr2
            j = i + 1;
            while(j < arr1.length){   //check every element in arr1
                if(arr1[i] != arr2[k]){
                    if(arr1[j] == arr2[k]){
                        int temp = arr1[i];
                        arr1[i] = arr1[j];
                        arr1[j] = temp;
                        i = i + 1;
                    }
                    else{
                        j++;
                    }
                }
                else{
                    i++;
                    j = i + 1;
                }
            }
            k++;
        }

        // If there are elements in arr1 (by now they will be at the end of arr1) that do not appear in arr2 then sort them.
        if(i < arr1.length){
            j = i + 1;
            while(i < arr1.length) {
                while(j < arr1.length){
                    if(arr1[i] > arr1[j]){
                        int temp = arr1[i];
                        arr1[i] = arr1[j];
                        arr1[j] = temp;
                    }
                    j++;
                }
                i++;
                j = i + 1;
            }
        }
        return arr1;
    }

    public static void main(String[] args){
        RelativeSortArray1122 r = new RelativeSortArray1122();
        System.out.println(Arrays.toString(r.relativeSortArray(new int[] {2,3,1,3,2,4,6,7,9,2,19}, new int[] {2,1,4,3,9,6})));
        System.out.println(Arrays.toString(r.relativeSortArray(new int[] {28,6,22,8,44,17}, new int[] {22,28,8,6})));
    }

}
