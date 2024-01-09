/*
Given two sorted integer arrays nums1 and nums2, return an array of their intersection.
Each element in the result must be unique and you may return the result in any order.



Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.


Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 */

import java.util.*;

public class Intersection_Of_Two_SortedArrays {

    HashSet<Integer> answer = new HashSet<>();
    //Time: O(m + n). Two pointers/2 pointers.
    //Space: O(1)
    public HashSet<Integer> intersection(int[] nums1, int[] nums2) {

        for(int i = 0, j =0; i< nums1.length && j < nums2.length; ){
            if(nums1[i] == nums2[j]){
                answer.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        return answer;
    }

    // Use HashMap. But the space complexity is O(n).
    //Time : O(m+n) (reading two inputs) + O(min(m,n) (reading map) = O(m+n)
    //Space: O(min(m,n)) = O(m) or O(n) whichever is minimum
    public HashSet<Integer> intersection_hash(int[] nums1, int[] nums2) {

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

        for(Map.Entry<Integer,Integer> pair : map.entrySet()){
            if(pair.getValue() == 2)
                answer.add(pair.getKey());
        }

        return answer;
    }


    public static void main(String[] args){
        Intersection_Of_Two_SortedArrays i = new Intersection_Of_Two_SortedArrays();
        System.out.println(Arrays.toString(i.intersection(new int[]{1,2,2,1}, new int[]{2,2}).toArray())); //2

        Intersection_Of_Two_SortedArrays i1 = new Intersection_Of_Two_SortedArrays();
        System.out.println(Arrays.toString(i1.intersection(new int[]{4,5,9}, new int[]{4,9,9,8,4}).toArray())); //9,4 or 4,9

        Intersection_Of_Two_SortedArrays i2 = new Intersection_Of_Two_SortedArrays();
        System.out.println(Arrays.toString(i2.intersection(new int[]{4,6,7,7,7,9}, new int[]{0,0,1,2,2,4,5,6,6}).toArray())); //4,6 or 6,4
    }
}
