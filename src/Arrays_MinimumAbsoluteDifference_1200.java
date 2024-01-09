/*
Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.

Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows

a, b are from arr
a < b
b - a equals to the minimum absolute difference of any two elements in arr


Example 1:

Input: arr = [4,2,1,3]
Output: [[1,2],[2,3],[3,4]]
Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
Example 2:

Input: arr = [1,3,6,10,15]
Output: [[1,3]]
Example 3:

Input: arr = [3,8,-10,23,19,-4,-14,27]
Output: [[-14,-10],[19,23],[23,27]]


Constraints:

2 <= arr.length <= 105
-106 <= arr[i] <= 106
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arrays_MinimumAbsoluteDifference_1200 {

    //Time: O(nlogn)
    //Space: O(n)
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;

        List<List<Integer>> answer = new ArrayList<>();

        for(int i = 0 ; i < arr.length - 1 ; i++) {  // < arr.length - 1  means do until 2 indexes before end of the array.

            if(arr[i+1] - arr[i] <= minDiff) {
                if(arr[i+1] - arr[i] < minDiff) {
                    answer.clear();
                }
                minDiff = arr[i+1] - arr[i];
                List<Integer> lst = new ArrayList<Integer>();
                lst.add(arr[i]);
                lst.add(arr[i+1]);
                answer.add(lst);
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Arrays_MinimumAbsoluteDifference_1200 m = new Arrays_MinimumAbsoluteDifference_1200();

        int[] nums1 = {4,2,1,3};

        System.out.println(m.minimumAbsDifference(nums1));
    }
}
