import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.



Example 1:

Input: nums = [1,2,3,1]
Output: true
Example 2:

Input: nums = [1,2,3,4]
Output: false
Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true



 */

public class Contains_duplicate_217 {


    //time: O(nlogn)
    //space: O(1)
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

    public boolean containsDuplicate_hashSet(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
//           if(set.contains(num))
//               return true;
//           else
//               set.add(num);
           if(!set.add(num))
               return true;
        }
        return false;
    }

    public boolean containsDuplicate_hashtable(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i : nums){
            map.put(i, map.getOrDefault(i,0) + 1);
            if( map.get(i) > 1)
                return true;
        }
        return false;
    }


    public static void main(String[] args){
        Contains_duplicate_217 c = new Contains_duplicate_217();
        System.out.println(c.containsDuplicate_hashtable(new int[] {1,2,3,1})); //true
        System.out.println(c.containsDuplicate_hashSet(new int[] {1,2,3,1})); //true
        System.out.println(c.containsDuplicate_hashSet(new int[] {1,2,3})); //false
        System.out.println(c.containsDuplicate(new int[] {1,2,3,1})); //true
        System.out.println(c.containsDuplicate(new int[] {1,2,3})); //false
    }
}
