package AppleLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {

    //Time: n^2  because O(n^2 + nlogn) = O(n^2)
    //Space: O(1)
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i< nums.length-2;){
            int j= i+1;
            int k= nums.length - 1;

            while(j < k){
                if(nums[i] + nums[j] + nums[k] == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    answer.add(list);
                    j++;
                    k--;
                    while(j<nums.length && nums[j] == nums[j-1]){
                        j++;
                    }
                    while(k >=0 && nums[k] == nums[k+1]){
                        k--;
                    }
                }
                else if(nums[i] + nums[j] + nums[k] > 0){
                    k--;
                }else{
                    j++;
                }

            }

            int currIval = nums[i];
            while (i < nums.length && nums[i] == currIval) {
                i++;
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        ThreeSum_15 s = new ThreeSum_15();
       System.out.println(Arrays.deepToString(s.threeSum(new int[]{-4, -1, -1, 0, 1, 2}).toArray())); // [[-1,-1,2],[-1,0,1]]
        System.out.println(Arrays.deepToString(s.threeSum(new int[]{0, 0, 0, 0}).toArray())); // [[0,0,0]]
        System.out.println(Arrays.deepToString(s.threeSum(new int[]{-1, 1, -1, 0}).toArray())); // [[0,0,0]]
    }

}
