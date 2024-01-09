import java.util.HashSet;

//The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.
//
//        Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.
//
//        Example 1:
//        Input: nums = [1,2,2,4]
//        Output: [2,3]
//        Note:
//        The given array size will in the range [2, 10000].
//        The given array's numbers won't have any order.

// Time - 0(n), Sapce - 0(n)
public class SetMismatch_645 {

    public int[] findErrorNums(int[] nums) {

        HashSet<Integer> set = new HashSet<Integer>();
        int duplicate = 0;
        int actualSum = 0;
        int[] ans = new int[2];

        for(int i = 0; i< nums.length ; i++){
            boolean b = set.add(nums[i]);
            if(!b){
                duplicate = nums[i];
            }
            else{
                actualSum = actualSum + nums[i];
            }
        }

        int expectedSum = nums.length * (nums.length + 1)/2;

         ans[0] = duplicate;
         ans[1] = expectedSum-actualSum;

        return ans;

    }

    public static void main(String[] args){
        SetMismatch_645 setMismatch = new SetMismatch_645();
        int nums[] =  {1,2,2,4}; // 2,3
        setMismatch.findErrorNums(nums);

    }
}
