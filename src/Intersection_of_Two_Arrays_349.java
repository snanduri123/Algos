import java.util.*;

/*
Given two integer arrays nums1 and nums2, return an array of their intersection.
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

public class Intersection_of_Two_Arrays_349 {

    //using two pointers.
    //Time Complexity - O(nlogn) - sort and use two pointers
    //Space Complexity - O(n) - because of set to remove duplicates
    public int[] intersection(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        HashSet<Integer> set = new HashSet<Integer>();


        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]); //add and also avoids duplicates.
                i++;
                j++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
                i++;
            }
        }

        int[] ans = new int[set.size()];
        int idx = 0;
        for (Integer num : set) {
            ans[idx++] = num;
        }
        return ans;
    }

    //using two hashsets.
    //Time Complexity - reading nums1 array to put in set1 is n
    //                 - reading nums2 array to find if it is present in set is m
    //                 - total O(m+n) or O(n)
    //Space Complexity - two sets  O(m) + O(n)
    public int[] intersection1(int[] nums1, int[] nums2) {

        HashSet<Integer> s1 = new HashSet<Integer>();
        HashSet<Integer> s2 = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            s1.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (s1.contains(nums2[i])) {
                s2.add(nums2[i]); //if answer is array list then use s1 set and remove from s1 as and when nums2[i] is found and then add it to answer list. So that extra s2 set is not used.
            }
        }

        int[] result = new int[s2.size()];
        int i = 0;
        for (Integer num : s2) {
            result[i++] = num;
        }
        return result;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        int[] values = new int[1001]; // The constraint is 1 <= nums1.length, nums2.length <= 1000 and 0 <= nums1[i], nums2[i] <= 1000
        int[] ans = new int[nums1.length];

        if (nums1.length > nums2.length) {
            return intersection2(nums2, nums1);
        }

        for (Integer num : nums1) {
            if (values[num] < 1) {   // 1 will be at index 0. 1000
                values[num] = values[num] + 1;
            }
        }

        int k = 0;
        for (Integer num : nums2) {
            if (values[num] == 1) {
                ans[k++] = num;
                values[num]--;
            }
        }
        //return Arrays.copyOfRange(ans,0,k);
        return Arrays.copyOf(ans, k);
    }


    // Use HashMap. But the space complexity is O(n).
    //Time : O(m+n) (reading two inputs) + O(min(m,n) (reading map) = O(m+n)
    //Space: O(min(m,n)) = O(m) or O(n) whichever is minimum
    //TODO: convert hashset to integer[]
    public HashSet<Integer> intersection_hash(int[] nums1, int[] nums2) {

        HashSet<Integer> answer = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums1.length; i++) {
            if (!map.containsKey(nums1[i])) {
                map.put(nums1[i], 1);
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                map.put(nums2[i], 2);
            }
        }

        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if (pair.getValue() == 2)
                answer.add(pair.getKey());
        }

        return answer;
    }

    public static void main(String[] args) {
        Intersection_of_Two_Arrays_349 i = new Intersection_of_Two_Arrays_349();
        System.out.println(Arrays.toString(i.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}))); //2
        System.out.println(Arrays.toString(i.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}))); //9,4 or 4,9
        System.out.println(Arrays.toString(i.intersection(new int[]{4, 7, 9, 7, 6, 7}, new int[]{5, 0, 0, 6, 1, 6, 2, 2, 4}))); //4,6 or 6,4
    }
}
