/*
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.



Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2


Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubarraySumEqualsK_560 { //medium

    List<List<Integer>> ans = new ArrayList<>();

    public int subarraySum(int[] nums, int k){
        findSum_recur( nums,  k,  0);
        return ans.size();
    }


    //Time : n^2. first n elements ( 0 to n) checked, next n - 1 elements (1 to n), next n-2 (2 to n)... = n + n-1 + n-2...= n(n+1)/2 = n^2.
    public void findSum_recur(int[] nums, int k, int pos) {

        if (pos == nums.length) {
            return;
        }

        List<Integer> currList = new ArrayList<>();
        int currSum = 0;
        for(int i=pos; i< nums.length; i++) {
            currList.add(nums[i]);
            currSum = currSum + nums[i];
            if (currSum == k) {
                ans.add(new ArrayList<>(currList));
            }
        }
        findSum_recur(nums, k, pos + 1);
    }

    public static void printSubArray(int [] input, int currIndex){

        if(currIndex==input.length)
            return;

        //print all the subarray from currIndex to end
        String result = "";
        for (int i = currIndex; i <input.length ; i++) {
            result += " " + input[i] + " ";
            System.out.print("[" +result + "] ");
        }
        printSubArray(input, currIndex+1);
    }


    public static void main(String[] args){
        SubarraySumEqualsK_560 s = new SubarraySumEqualsK_560();

       //s.printSubArray(new int[]{4, 6, 8},0); //2

        System.out.println(s.subarraySum(new int[]{1,-1,0}, 0)); //3
        System.out.println(Arrays.deepToString(s.ans.toArray())); //2
        s.ans.clear();

        System.out.println(s.subarraySum(new int[]{1,1,1}, 2)); //2
        System.out.println(Arrays.deepToString(s.ans.toArray())); //2
        s.ans.clear();

        System.out.println(s.subarraySum(new int[]{1,2,3}, 3)); //2
        System.out.println(Arrays.deepToString(s.ans.toArray())); //2

        s.ans.clear();
        System.out.println(s.subarraySum(new int[]{1,1,1,2,3,4}, 3)); //3
        System.out.println(Arrays.deepToString(s.ans.toArray())); //2
    }

    //works only for +ve numbers
    public int subarraySum_forPositive(int[] nums, int k){
        int count = 0;
        int arrStartIdx = 0;
        int sum = 0;
        for(int i = 0; i< nums.length && arrStartIdx <= i;){
            sum = sum + nums[i];  //add the number and verify if the sum is k
            if(sum == k){
                count++;
                sum = sum - nums[arrStartIdx];  //subtract subArr start idx from sum
                arrStartIdx = arrStartIdx + 1;  //update the subArr start idx (to check new subarray)
                i++;
            }
            else if(sum < k){
                i++;
            }else if(sum > k){
                sum = sum - nums[arrStartIdx];  //subtract subArr start idx from sum
                arrStartIdx = arrStartIdx + 1;   //update the subArr start idx (to check new subarray)
                sum = sum - nums[i];    //** subtract curr val because in loop you will again add it.
            }
        }
        return count;
    }

}
