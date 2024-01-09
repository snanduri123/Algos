import java.util.Arrays;

public class Prob2741 {

    public int specialPerm(int[] nums) {
        return permute(nums, 0, 0, -1);
    }

    private int permute(int[] nums, int bitSet, int index, int prevNum) {
        if (index == nums.length) {
            return 1;
        }
        int count = 0;
        for (int j = 0 ; j < nums.length ; j++) {
            if ((bitSet & (1 << j)) == 0 && (index == 0 || nums[j] % prevNum == 0|| prevNum % nums[j] == 0)) {
                bitSet |= (1 << j);
                count += permute(nums, bitSet, index + 1, nums[j]);
                bitSet &= ~(1 << j);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Prob2741().specialPerm(new int[]{31,93,6}));
    }
}
