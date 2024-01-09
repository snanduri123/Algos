package AppleLeetcode;
/*
You are given three positive integers: n, index, and maxSum. You want to construct an array nums (0-indexed) that satisfies the following conditions:

nums.length == n
nums[i] is a positive integer where 0 <= i < n.
abs(nums[i] - nums[i+1]) <= 1 where 0 <= i < n-1.
The sum of all the elements of nums does not exceed maxSum.
nums[index] is maximized.
Return nums[index] of the constructed array.

Note that abs(x) equals x if x >= 0, and -x otherwise.



Example 1:

Input: n = 4, index = 2,  maxSum = 6
Output: 2
Explanation: nums = [1,2,2,1] is one array that satisfies all the conditions.
There are no arrays that satisfy all the conditions and have nums[2] == 3, so 2 is the maximum nums[2].
Example 2:

Input: n = 6, index = 1,  maxSum = 10
Output: 3


Constraints:

1 <= n <= maxSum <= 109
0 <= index < n
 */
public class BinSearch_MaxValue_At_Given_Idx_1802 {

    public int maxValue(int n, int index, int maxSum) {

        long start = 0;
        long end = maxSum;
        long maxVal = 0;

        while(start <= end){

            long mid = start + (end - start)/2;

            if(isMax(mid, n, index, maxSum)){
                maxVal = mid;
                start = mid + 1;
            }else{
                end = mid -1;
            }
        }
        return (int)maxVal;
    }

    public boolean isMax(long val,int n, int index, int maxSum) {

       // int lefToMidLen = index + 1;
        int rightLen = n - index - 1;
        long leftSum = calcSum(val) - calcSum(val-index -1);
        long rightSum = calcSum(val-1) - calcSum(val-rightLen -1);

        if(leftSum + rightSum <= maxSum){
            return true;
        }
        else{
            return false;
        }
    }

    public long calcSum(long n){
        return ((n * (n + 1)) / 2);
    }

    public static void main(String[] args){
        BinSearch_MaxValue_At_Given_Idx_1802 b = new BinSearch_MaxValue_At_Given_Idx_1802();
        System.out.println(b.maxValue(4,2,6)); //2 [1,2,2,1]
        System.out.println(b.maxValue(6,1,10));// 3
        System.out.println(b.maxValue(3,2,18)); //7
    }
}
