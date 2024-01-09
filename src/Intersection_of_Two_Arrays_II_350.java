import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


/*
Given two integer arrays nums1 and nums2, return an array of their intersection.
 Each element in the result must appear as many times as it shows in both arrays
 and you may return the result in any order.



Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]


Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.


Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000


Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class Intersection_of_Two_Arrays_II_350 {

    //Time : O(mlogn + Onlogn)
    //Space : O(logn + logm) for sorting. If that is not needed to tell then it is O(1)
    //using sorting and 3 pointers/three pointers. Use this method if output has to be sorted or when input is sorted(then no need do sort).
    //    The third pointer is for adding answer in nums1 array (we could have used separate answer arrayList instead of overwriting existing array).
    public int[] intersect(int[] nums1, int[] nums2) {

       Arrays.sort(nums1);
       Arrays.sort(nums2);

       int k =0;
       for(int i =0, j=0; i<nums1.length && j<nums2.length;){

           if(nums1[i] < nums2[j]) {
               i++;
           }
           else if(nums2[j] < nums1[i]){
               j++;
           }
           else{
               nums1[k++] = nums2[j];
               i++;j++;
           }

        }


        //return  Arrays.copyOfRange(nums1,0,k) ;
        return Arrays.copyOf(nums1,k);
    }

    //Time : O(n + m)
    //Space : O(min(n,m)) //hash map to store numbers (and their counts) from the smaller array.
    //using hashmap for processing.
    public int[] intersect2(int[] nums1, int[] nums2) {

        int[] ans = new int[nums1.length]; //output can contain numbers max of nums1 size.
        //Later on if it has less elements than the original size
        //then while returning shrink it.

//It's a good idea to check array sizes and use a hash map for the smaller array. It will reduce memory usage when one of the arrays is very large.
        if(nums1.length > nums2.length){
            return intersect2(nums2, nums1);
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums1){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        int idx = 0;

        for(int num : nums2){
            int freq =  map.getOrDefault(num,0);
            if(freq > 0){
                ans[idx++] = num;
                map.put(num, freq - 1);
            }
        }
        return  Arrays.copyOfRange(ans,0,idx) ;  //the initial created size of ans array might be bigger than needed, so return only the right numbers.
    }

    public static void main(String[] args){
        Intersection_of_Two_Arrays_II_350 i = new Intersection_of_Two_Arrays_II_350();
        System.out.println(Arrays.toString(i.intersect(new int[]{1,2,2,1}, new int[]{2,2})));

    }
}
