import java.util.ArrayList;
import java.util.Arrays;

public class CountOfElementsHavingSum {

    int count = 0;

    static Boolean check_if_sum_possible(ArrayList<Long> arr, Long k) {
        // Write your code here.
        return isSum(arr, k, 0, 0L);
    }

    static boolean isSum(ArrayList<Long> arr, Long k, int pos, Long currSum) {


        if (currSum == k) {
            return true;
        }

        for (int i = pos; i < arr.size(); i++) {
            if(isSum(arr, k, i + 1, currSum + arr.get(i)))
                return true;
        }
        return false;
    }

    public int findTargetSumWays(int[] nums, int target) {
        findTargetSumWays(nums, target, 0, 0);
        return  count;
    }

    public  void findTargetSumWays(int[] nums, int target, int pos, int currSum) {
        if (currSum == target) {
            count++;
        }

        for (int i = pos; i < nums.length; i++) {
            findTargetSumWays(nums, target, i + 1, currSum + nums[i]);
        }
    }


    public static void main(String[] args) {
        CountOfElementsHavingSum c = new CountOfElementsHavingSum();

        ArrayList<Long> arr = new ArrayList<>();
        arr.add(2L);
        arr.add(4L);
        arr.add(8L);
        System.out.println(c.check_if_sum_possible(arr,6L));

        //System.out.println(c.findTargetSumWays(new int[]{1,,1,1,1}, 3));
    }
}

