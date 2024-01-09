/*
The power of the string is the maximum length of a non-empty substring that contains only one unique character.

Given a string s, return the power of s.



Example 1:

Input: s = "leetcode"
Output: 2
Explanation: The substring "ee" is of length 2 with the character 'e' only.
Example 2:

Input: s = "abbcccddddeeeeedcba"
Output: 5
Explanation: The substring "eeeee" is of length 5 with the character 'e' only.


Constraints:

1 <= s.length <= 500
s consists of only lowercase English letters.
 */

public class LongestConsecutiveCharacters_1446 {

    //Question same as StringCompression_443, Remove_Duplicates_From_Sorted_Array_26, Remove_Duplicates_From_Sorted_Array_II_80
    //Time: O(n)
    //Space: O(1)
    public int maxPower(String s) {
        char maxChar = s.charAt(0);  //return this variable if ans is char.
        int maxCount = 1;
        for(int i=0; i< s.length(); i++){
            int count = 1;
            while(i+1 < s.length() && s.charAt(i) == s.charAt(i+1)){
                count++;
                if(count > maxCount){
                    maxCount = count;
                    maxChar = s.charAt(i);
                }
                i++;
            }
        }
        return maxCount;
    }
}
