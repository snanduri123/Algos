import java.util.*;

/*Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:
Input: [3,2,3]
Output: [3]

Example 2:
Input: [1,1,1,3,3,2,2,2]
Output: [1,2]

*/

//TODO:
public class Majority_Element_II_229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> numFreq : map.entrySet()) {
            if (numFreq.getValue() > len / 3)
                ans.add(numFreq.getKey());
        }
        return ans;
    }

    public static void main(String[] args){
        Majority_Element_II_229 m = new Majority_Element_II_229();
        System.out.println(Arrays.toString(m.majorityElement(new int[]{3,2,3}).toArray())); //3
        System.out.println(Arrays.toString(m.majorityElement(new int[]{1}).toArray())); //1
        System.out.println(Arrays.toString(m.majorityElement(new int[]{1,2}).toArray())); //1,2

    }
}
