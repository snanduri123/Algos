/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

 */
public class Maximum_Subarray_Sum_53 {
     /*Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

    Example:

    Input: [-2,1,-3,4,-1,2,1,-5,4],
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.
    */

    public static void main(String[] args) {
        int sum;
        int[] a = {-4, 1, 2, 0, -1, -4, 100}; //100
        sum = maxSubArray2(a);
        System.out.println(sum);

        int[] b = {-2, 1, -3, 4, -1, 2, 1, -5, 4}; //6
        sum = maxSubArray2(b);
        System.out.println(sum);

        int[] b2 = {-2, -1, -3, -4, -1, -2, -3, -5, -4}; //all -ve numbers. -1
        sum = maxSubArray2(b2);
        System.out.println(sum);
    }

    /*Time complexity : n
      Space complexity -  stack: 1
                          heap : n  (res array)
     */

    public static int maxSubArray(int[] a) {
        int[] res = new int[a.length];

        res[0] = a[0]; //at 0th index of arr a, a[0] is only the highest sum so store it in b[0]
        int maxPos = 0;
        //at each index find what is the possible maximum sum
        for (int i = 1; i < a.length; i++) {
            res[i] = Math.max(a[i], a[i] + res[i - 1]);  //at any given index of arr a, check if the curr value is big or sum of it and previously calculated sum is big

            //find maximum in the result array simultaneously
            maxPos = res[i] > res[maxPos] ? i : maxPos;  //at any given index of arr a, check if the curr value is big or sum of it and previously calculated sum is big
        }

        return res[maxPos];
    }

    /*Time complexity : n
      Space complexity -  stack: 1
    */
    public static int maxSubArray2(int[] a) {

        int beforeMaxSum = a[0]; //max sum calculated at i-1th position
        int soFarMaxSum = a[0]; //max sum calculated so far until i-1th postion
        //at each index find what is the possible maximum sum
        for (int i = 1; i < a.length; i++) {
            int maxSumForCurrIdx = Math.max(a[i], a[i] + beforeMaxSum);  //at any given index of arr a, check if the curr value is big or sum of it and previously calculated sum is big
            //find maximum in the result array simultaneously
            soFarMaxSum = Math.max(maxSumForCurrIdx, soFarMaxSum);  //at any given index of arr a, check if the curr value is big or sum of it and previously calculated sum is big
            beforeMaxSum = maxSumForCurrIdx;

        }
        return soFarMaxSum;
    }

    //at every idx, we see if we can add curr val to sum calculated up till prev idx (prev sub array).
    // If adding the old sum to curr val makes it greater, then old sum is considered otherwise
    // just consider that curr idx as the sum you can get uptil that idx (or subarray ending with the curr idx.)

    public int maxSubArray3(int[] nums) {
        int maxSum=Integer.MIN_VALUE;
        int currSum = 0;
        for(int i=0; i< nums.length; i++){
            if(nums[i] + currSum >= nums[i]){
                currSum = nums[i] + currSum;
            }else{
                currSum = nums[i];
            }
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }


}
