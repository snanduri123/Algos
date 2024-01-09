package AppleLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_closest_16 {

    //Time: n^2  because O(n^2 + nlogn) = O(n^2) , three pointer
    //Space: O(1)
    public int threeSumClosest(int[] nums, int target) {
        int minDiff = Integer.MAX_VALUE;
        int closest = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int absDiff = Math.abs((nums[i] + nums[j] + nums[k]) - target);
                if (absDiff < minDiff) {
                    closest = nums[i] + nums[j] + nums[k];
                    minDiff = absDiff;
                }
                if (nums[i] + nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        ThreeSum_closest_16 s = new ThreeSum_closest_16();
       // System.out.println(s.threeSumClosest(new int[]{-1,2,1,-4}, 1)); // 2
        System.out.println(s.threeSumClosest(new int[]{1,1,1,0}, -100)); // 3

    }

}
