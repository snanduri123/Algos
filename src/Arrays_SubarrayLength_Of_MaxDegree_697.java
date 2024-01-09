/*
Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.



Example 1:

Input: nums = [1,2,2,3,1]
Output: 2
Explanation:
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
Example 2:

Input: nums = [1,2,2,3,1,4,2]
Output: 6
Explanation:
The degree is 3 because the element 2 is repeated 3 times.
So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.


Constraints:

nums.length will be between 1 and 50,000.
nums[i] will be an integer between 0 and 49,999.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Arrays_SubarrayLength_Of_MaxDegree_697 {


    //Time : O(n)
    //Space: O(n) + O(n) = O(n)
    public int findShortestSubArray(int[] nums) {

        HashMap<Integer, Integer> numFreq = new HashMap<>();     // to maintain frequency of a num.
        HashMap<Integer, Integer> numStartIdx = new HashMap<>(); // to maintain start index of a num.

        int degree = 0;
        int len = 0;

        for (int i = 0; i < nums.length; i++) {

            numFreq.put(nums[i], numFreq.getOrDefault(nums[i], 0) + 1);
            numStartIdx.putIfAbsent(nums[i], i);

            if (numFreq.get(nums[i]) > degree) {
                degree = numFreq.get(nums[i]);
                len = i - numStartIdx.get(nums[i]) + 1; // 1 2 2 3 --> 2,2 sub array is the longest length. indexes ---> 2 - 1 = 1 but length of subarray is 2 so add 1 to the end index and then compute length.
            } else if (numFreq.get(nums[i]) == degree) {
                len = Math.min(len, i - numStartIdx.get(nums[i]) + 1);
            }
        }

        return len;
    }


    //Time: O(n) nums array + O(n) map
    //space: O(n) freqmap + O(n) idxmap
    public int findShortestSubArray2(int[] nums) {

        int degree = 0;
        int shortestLen = Integer.MAX_VALUE;


        HashMap<Integer,Integer> map = new HashMap<>();
        int[][] index = new int[50000][2];
        for(int[] idx : index)
            Arrays.fill(idx, -1);

        for(int i = 0; i< nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
            if(map.get(nums[i]) >= degree){
                degree = map.get(nums[i]);
            }
            if(index[nums[i]][0] == -1) {
                index[nums[i]][0] = i;
            }
            else{
                index[nums[i]][1] = i;
            }
        }

        if(degree == 1)
            return 1;

        for(Map.Entry<Integer,Integer> pair : map.entrySet()){
            if(pair.getValue() == degree){
                int num = pair.getKey();

                shortestLen = Math.min(shortestLen, index[num][1] - index[num][0] + 1);
            }
        }
        return shortestLen;
    }

    public static void main(String[] args) {
        Arrays_SubarrayLength_Of_MaxDegree_697 S = new Arrays_SubarrayLength_Of_MaxDegree_697();
        System.out.println(S.findShortestSubArray(new int[]{1})); // 1
        System.out.println(S.findShortestSubArray(new int[]{2,3,4})); // 1
        System.out.println(S.findShortestSubArray(new int[]{1, 2, 2, 3, 1})); /* Ans = 2. The input array has a degree of 2 because both elements 1 and 2 appear twice.
                                                                                Of the subarrays that have the same degree:
                                                                                [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
                                                                                The shortest length is 2. So return 2.*/
        System.out.println(S.findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2})); /* Ans = 6. The degree is 3 because the element 2 is repeated 3 times.
                                                                                   So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6. */
        System.out.println(S.findShortestSubArray(new int[]{1, 2, 3, 2, 3})); /* Ans = 3. Both 2 and 3 occur 2 times each. Their array length difference
                                                                                  for 2 : (3 - 1) + 1 = 3
                                                                                  for 3: (4 - 1) + 1 = 3
                                                                                  So one of them is returned.*/
        System.out.println(S.findShortestSubArray(new int[]{1, 2, 3, 2, 3, 2})); /*5 for number 2.  */
        System.out.println(S.findShortestSubArray(new int[]{2, 1, 1, 2, 1, 3, 3, 3, 1, 3, 1, 3, 2})); /*7 for number 3 (degree 5) -> (11 - 5) + 1   . Though number 1 has same degree '5', the shortest length is for number 3.*/

    }

}
