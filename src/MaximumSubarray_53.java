public class MaximumSubarray_53 {
    //Time: O(n)
    //Space: O(1)

    //at every idx, we see if we can add curr val to sum calculated up till prev idx (prev sub array).
    // If adding the old sum to curr val makes it greater, then old sum is considered otherwise
    // just consider that curr idx as the sum you can get uptil that idx (or subarray ending with the curr idx.)

    public int maxSubArray(int[] nums) {
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

    public static void main(String[] args){
        MaximumSubarray_53 m = new MaximumSubarray_53();
        System.out.println(m.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4})); //6
        System.out.println(m.maxSubArray(new int[]{1})); //1
        System.out.println(m.maxSubArray(new int[]{5,4,-1,7,8})); //23
        System.out.println(m.maxSubArray(new int[]{-2,1})); //1

    }
}
