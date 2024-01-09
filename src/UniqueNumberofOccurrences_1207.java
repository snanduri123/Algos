/*Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.



Example 1:

Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
Example 2:

Input: arr = [1,2]
Output: false
Example 3:

Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true


Constraints:

1 <= arr.length <= 1000
-1000 <= arr[i] <= 1000
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UniqueNumberofOccurrences_1207 {

    //Time complexity - O(n)
    //Space complexity - O(1) (Hashmap get is O(1)) + O(n) Hashset
    public boolean uniqueOccurrences2(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : arr)
            count.put(a, 1 + count.getOrDefault(a, 0));
        return count.size() == new HashSet<>(count.values()).size(); // if map size and set size is same then it is true.
    }

    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int n : arr){
            map.put(n, map.getOrDefault(n,0) + 1);
        }

        HashSet<Integer> set = new HashSet<>();

        for(Map.Entry<Integer,Integer> pair : map.entrySet()){

            if(set.contains(pair.getValue())){
                return false;
            }
            else{
                set.add(pair.getValue());
            }
        }
        return true;
    }

    public static void main(String[] args){
        UniqueNumberofOccurrences_1207 u = new UniqueNumberofOccurrences_1207();
        System.out.println(u.uniqueOccurrences(new int[] {1,2,2,1,1,3})); //true
        System.out.println(u.uniqueOccurrences(new int[] {1,2})); //false  - two numbers with same frequency
        System.out.println(u.uniqueOccurrences(new int[] {-3,0,1,-3,1,1,1,-3,10,0})); //true - -ves, +ves, 0 of different freq
        System.out.println(u.uniqueOccurrences(new int[] {12,12,12,12,12,12,12})); //true  - only one number multiple times
        System.out.println(u.uniqueOccurrences(new int[] {1,2,2,1,1,3,3})); //false

    }
}
