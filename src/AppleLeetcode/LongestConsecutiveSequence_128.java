package AppleLeetcode;
/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.



Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9


Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
 */
import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence_128 {
    //Time: O(n)
    //Space: O(n)
    // Use hashmap first to store all the numbers with value 0(unvisited).
    // For each number in hashmap,
    //   check if it is not previously checked for long length (val==0) and then calculate maxlength using recursion
    //   from its next number and add 1 to the length to update its value.
    public int longestConsecutive(int[] nums){
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, 0);
        }
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            int len = getLength(pair.getKey(), map); //find consecutive length in array from curr key number
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }

    //In recursion, check if there is next element for current number and add 1.
    public int getLength(int num, HashMap<Integer, Integer> map) {
        if (map.containsKey(num)) {
            if (map.get(num) == 0) {
                int lenFromNextNum = getLength(num + 1, map); //get length for nextNumber
                map.put(num, lenFromNextNum + 1);
            }
            return map.get(num);
        } else {
            return 0; //if a (next) number is not there then 0 will be returned
        }
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence_128 l = new LongestConsecutiveSequence_128();
        System.out.println(l.longestConsecutive(new int[]{100,4,200,1,3,2})); //4 , [1, 2, 3, 4]
        System.out.println(l.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1})); //9 [0,3,7,2,5,8,4,6,0,1]
    }
}
