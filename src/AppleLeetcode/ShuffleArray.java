package AppleLeetcode;

import java.util.Arrays;
import java.util.Random;

public class ShuffleArray {
    int[] numsCopy;
    int[] numsCopy2;
    public ShuffleArray(int[] nums) {
        numsCopy = Arrays.copyOf(nums,nums.length);
        numsCopy2 = Arrays.copyOf(nums,nums.length);
    }

    public int[] reset() {
        return numsCopy;
    }

    public int[] shuffle() {
        for(int i=0; i< numsCopy2.length; i++){
            Random r = new Random();
            int random = r.nextInt(i, numsCopy2.length);
            int temp = numsCopy2[i];
            numsCopy2[i] = numsCopy2[random];
            numsCopy2[random] = temp;
        }
        return numsCopy2;
    }
}
