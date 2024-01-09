/*(Given an array of integers nums and an integer target,
return indices of the two numbers such that they add up to target.

 Each input may have more than one solution, and there can be duplicates

You can return the answer in any order.

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSum_with_duplicates {

    //Time complexity - O(n)
    //Space complexity - O(n)
    public ArrayList<int[]> twoSum(int[] nums, int target) {

        ArrayList<int[]> answer = new ArrayList<>();
        HashMap<Integer, List<Integer>> numMap = new HashMap<>();

        for(int i = 0; i< nums.length; i++){
            int complement = target - nums[i];
            List<Integer> idxList;
            if(!numMap.containsKey(complement)){
                idxList = new ArrayList<>();
                idxList.add(i);
                numMap.put(nums[i], idxList); // Map maintains the input number and its index
            }
            else {
                idxList = numMap.get(complement);
                for(int idx : idxList){
                    answer.add(new int[]{i, idx});
                }
                if(!numMap.containsKey(nums[i])) { // the current val could be a new key
                    numMap.put(nums[i], idxList);
                }
                else{   //or it might be duplicate (input has duplicates) then add it's index also to the existing list.
                    numMap.get(nums[i]).add(i);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        TwoSum_with_duplicates t = new TwoSum_with_duplicates();
        System.out.println(Arrays.deepToString(t.twoSum(new int[] {2,6,11,15,4,4,4,4,-14}, 8).toArray()));
        //[[1, 0], [5, 4], [6, 4], [6, 5], [7, 4], [7, 5], [7, 6]]
    }

}
