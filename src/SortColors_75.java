/*
You are given an array of 0s and 1s in random order. Segregate 0s on left side and 1s on right side of the array [Basically you have to sort the array]. Traverse array only once.

Input array   =  [0, 1, 0, 1, 0, 0, 1, 1, 1, 0]
Output array =  [0, 0, 0, 0, 0, 1, 1, 1, 1, 1]

This is small problem of Dutch National Flag problem

 */

import java.util.Arrays;

public class SortColors_75 {

    //use three pointers
    //1 pointer tracks where to place 0
    //1 pointer (from backward) tracks where to place 2
    //1 pointer to iterate the array
    //Time : O(n)  --> 1 pass algorithm
    //Space: O(1)
    public void sortColors(int a[]){
        int i = 0;  //iterating idx
        int p0 = 0;
        int p2 = a.length-1;
        while( i <= p2){  //all 2s are shifted to right of the array
            if(a[i] == 0){     //if you find 0 , swap it with pointer0 and then move to next element from curr idx.
                int temp = a[p0];
                a[p0] = 0;
                a[i] = temp;
                p0++;
                i++;  // important because if a[i]=0 and a[p0] = 0 then 0 swaps with 0 and i should be incremented otherwise it will stuck pointing to value 0
            }else if(a[i] == 2){  //if you find 2, swap it with pointer2 but do not move to next element from current idx.
                int temp = a[p2];
                a[p2] = 2;
                a[i] = temp;
                p2--;
            } else if(a[i] == 1){  // //if you find 1, then do not do anything, leave it in its place and move on to next idx.
                i++;
            }
        }
    }

    //Time : O(n)  --> 2 pass algorithm
    //Space: O(1)
    public void sortColors1(int a[]){
        int count0 = 0;
        int count1 = 0;

        for(int i = 0; i < a.length; i++){
            if (a[i] == 0)
                count0++;
            if (a[i] == 1)
                count1++;
        }

        int i=0;
        while (  i < a.length){
            if(i < count0){  //remember its not "<=" because i starts from 0.
                a[i] = 0;
            }
            else if(i < count0 + count1){
                a[i] = 1;
            }
            else {
                a[i] = 2;
            }
            i++;
        }


    }

    public static void main(String[] args){
        SortColors_75 s = new SortColors_75();

        int[] a1 = new int[] {2,0,2,1,1,0};
        s.sortColors(a1);
        System.out.println(Arrays.toString(a1)); //[0,0,1,1,2,2]

//        int[] a2 = new int[] {2,0,1};
//        s.sortColors(a2);
//        System.out.println(Arrays.toString(a2)); //[0,1,2]
//
//        int[] a3 = new int[] {2,1,1,0};
//        s.sortColors(a3);
//        System.out.println(Arrays.toString(a3)); //[0,1,1,2]
//
//        int[] a4 = new int[] {2,2,2,2};
//        s.sortColors(a4);
//        System.out.println(Arrays.toString(a4)); //[2,2,2,2]

    }

}
