package AppleLeetcode;

public class Maximum_Sum_Subarray_53 {
    //Time: O(n)
    //Space: O(1)
    //at every idx, we see if we can add curr val to sum calculated up till prev idx (prev sub array).
    // If adding the old sum to curr val makes it greater, then old sum is considered otherwise
    // just consider that curr idx as the sum you can get up till that idx (or subarray with the curr idx and size of 1)
    public int maxSubArray1(int[] nums) {
        int maxSum=Integer.MIN_VALUE;
        int currSum = 0;  //do not initialize to Integer.MIN_VALUE bcoz when it is added with -ve val at nums[i] then it will undergo INTGER OVERFLOW.
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

    //Time: O(n)
    //Space: O(1)
    public int maxSubArray(int[] nums) {
        int currSubArraySum = nums[0];
        int maxSubArraySum = nums[0];
        for(int i=1; i< nums.length;i++){
            // If current_subarray is negative, throw it away. Otherwise, keep adding to curr number
            currSubArraySum = Math.max(nums[i], currSubArraySum + nums[i]);
            maxSubArraySum = Math.max(maxSubArraySum, currSubArraySum);
        }
        return maxSubArraySum;
    }

    public static void main(String[] args){
        Maximum_Sum_Subarray_53 m = new Maximum_Sum_Subarray_53();
        System.out.println(m.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4})); //6
//        System.out.println(m.maxSubArray(new int[]{1})); //1
//        System.out.println(m.maxSubArray(new int[]{5,4,-1,7,8})); //23
//        System.out.println(m.maxSubArray(new int[]{-2,1})); //1
    }
}
