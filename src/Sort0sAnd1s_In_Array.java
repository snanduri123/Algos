
/*
You are given an array of 0s and 1s in random order. Segregate 0s on left side and 1s on right side of the array [Basically you have to sort the array]. Traverse array only once.

Input array   =  [0, 1, 0, 1, 0, 0, 1, 1, 1, 0]
Output array =  [0, 0, 0, 0, 0, 1, 1, 1, 1, 1]

This is small problem of Dutch National Flag problem

 */

import java.util.Arrays;

public class Sort0sAnd1s_In_Array {

    //use two pointers
    //Time : O(n)  --> 1 pass algorithm
    //Space: O(1)
    public void sort(int a[]) {
        int i = 0;
        int j = a.length - 1;
        while (i < j) {
            while (a[i] == 0) { //skip all 0's
                i++;
            }
            while (a[j] == 1) { //skip all 1's
                j--;
            }

            if (i < j) {  //if i < j then you will reach here only if i has 1 and j has 0.
                a[i] = 0;
                a[j] = 1;
            }
        }
    }

    //Time : O(n)  --> 2 pass algorithm
    //Space: O(1)
    public void sort2(int a[]) {
        int count0 = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0)
                count0++;
        }

        int i = 0;
        while (i < a.length) {
            if (i < count0) {  //remember its not "<=" because i starts from 0.
                a[i] = 0;
            } else {
                a[i] = 1;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        Sort0sAnd1s_In_Array s = new Sort0sAnd1s_In_Array();

        int[] a1 = new int[]{0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        s.sort(a1);
        System.out.println(Arrays.toString(a1)); //[0, 0, 0, 0, 0, 1, 1, 1, 1, 1]

        int[] a2 = new int[]{0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
        s.sort(a2);
        System.out.println(Arrays.toString(a2)); //[0, 0, 0, 0, 0, 1, 1, 1, 1, 1]

        int[] a3 = new int[]{1, 1, 1, 1, 1, 0, 0, 0, 0, 0};
        s.sort(a3);
        System.out.println(Arrays.toString(a3));

        int[] a4 = new int[]{1, 1, 1, 1, 0, 0, 0, 0, 0};
        s.sort(a4);
        System.out.println(Arrays.toString(a4));
    }

}
