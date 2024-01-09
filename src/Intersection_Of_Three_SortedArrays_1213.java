/*
Given three sorted integer arrays nums1,nums2 and nums3, return a sorted array of their intersection.
Each element in the result must be unique and you may return the result in any order.



Example 1:

Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
Output: [1,5]
Explanation: Only 1 and 5 appeared in the three arrays.



Constraints:

1 <= arr1.length, arr2.length, arr3.length <= 1000
1 <= arr1[i], arr2[i], arr3[i] <= 2000
 */

import java.util.*;

public class Intersection_Of_Three_SortedArrays_1213 {

    //Time: O(l+ m + n). Three pointers method.
    //Space: O(1)
    public int[] intersection(int[] nums1, int[] nums2, int[] nums3) {


       List<Integer> tempAnswer = new ArrayList<>();

        for(int i = 0, j =0, k= 0; i< nums1.length && j < nums2.length && k < nums3.length; ){
            if(nums1[i] == nums2[j] && nums1[i] == nums3[k]){
                tempAnswer.add(nums1[i]);
                i++;
                j++;
                k++;
            }else {
               if( nums1[i] < nums2[j])
               {
                   if(nums1[i] < nums3[k]){
                       i++;
                   } else{
                       k++;
                   }
               }else {
                   if(nums2[j] < nums3[k]){
                       j++;
                   } else{
                       k++;
                   }
               }
            }
        }

        int[] answer = new int[tempAnswer.size()];
        int i=0;
        for(Integer ans : tempAnswer){
            answer[i] = ans;
            i++;
        }
        return answer;
    }

    // Use HashMap. But the space complexity is O(n).
    //Time : O(l+m+n) (reading three inputs) + O(min(m,n) (reading map) = O(m+n)
    //Space: O(min(m,n)) = O(m) or O(n) whichever is minimum
    public int[] intersection_hash(int[] nums1, int[] nums2, int[] nums3) {

        List<Integer> tempAnswer = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap();
        for(int i = 0;  i< nums1.length ; i++){
            if(!map.containsKey(nums1[i])){
                map.put(nums1[i], 1);
            }
        }

        for(int i = 0;  i< nums2.length ; i++){
            if(map.containsKey(nums2[i])){
                map.put(nums2[i], 2);
            }
        }

        for(int i = 0;  i< nums3.length ; i++){
            if(map.containsKey(nums3[i])){
                map.put(nums3[i], 3);
            }
        }

        for(Map.Entry<Integer,Integer> pair : map.entrySet()){
            if(pair.getValue() == 3)
                tempAnswer.add(pair.getKey());
        }

        int[] answer = new int[tempAnswer.size()];
        int i=0;
        for(Integer ans : tempAnswer){
            answer[i] = ans;
        }

        return answer;
    }


    public static void main(String[] args){
        Intersection_Of_Three_SortedArrays_1213 i = new Intersection_Of_Three_SortedArrays_1213();
        System.out.println(Arrays.toString(i.intersection(new int[]{1, 5, 10, 20, 40, 80}, new int[]{6, 7, 20, 80, 100}, new int[]{3, 4, 15, 20, 30, 70, 80, 120}))); //20, 80

        Intersection_Of_Three_SortedArrays_1213 i1 = new Intersection_Of_Three_SortedArrays_1213();
        System.out.println(Arrays.toString(i.intersection(new int[]{1, 5, 5}, new int[]{3, 4, 5, 5, 10}, new int[]{5, 5, 10, 20}))); //5,5

        Intersection_Of_Three_SortedArrays_1213 i2 = new Intersection_Of_Three_SortedArrays_1213();
        System.out.println(Arrays.toString(i.intersection(new int[]{1, 5, 5}, new int[]{3, 4, 5, 5, 10}, new int[]{5, 10, 20}))); //5
    }
}
