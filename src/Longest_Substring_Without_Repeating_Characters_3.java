/*
Given a string s, find the length of the longest
substring
 without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */

import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_Without_Repeating_Characters_3 { //Medium

    //Time: O(n)
    //Space: O(1)
    //Two pointers (start, end) both begin from the beginning. end iterates over each character in the string.
    // whenever there is valid (within window) duplicate, start is updated to  oldduplicate's position + 1;
    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int subStringStart = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= subStringStart) { // if previous occurrence (duplicate) is in the window of current substring then do not include current character in finding length
                maxLength = Math.max(maxLength, i - subStringStart);
                subStringStart = map.get(s.charAt(i)) + 1; //start from char next to the old duplicate char
            } else {  //if you did not see the duplicate or seen the duplicate but it was already part of prev substring length (means it is not in the current substring window, ie., < currSubString start)
                maxLength = Math.max(maxLength, i - subStringStart + 1); //include current element in the length. //Eg: abba - first ab(len =2) is calculated, and then new substring starts at second b(idx=2) and when you see again a, the length should be calculated from only newSubstring start idx and ignore old occurrence of a.
            }
            map.put(s.charAt(i), i);  //current element is always added to map (irrespective of having duplicate or being a new one)
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {

        Map<Character, Integer> map = new HashMap<>();

        int maxLength = 0;
        int prevSeen = 0;

        int i=0;

        for( ;i< s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                maxLength = Math.max(maxLength, i - prevSeen);
                prevSeen =  i;
            }
            map.put(s.charAt(i), i);
        }

        return Math.max(maxLength, i - prevSeen);
    }

    public static void main(String[] args) {
        Longest_Substring_Without_Repeating_Characters_3 l = new Longest_Substring_Without_Repeating_Characters_3();
        System.out.println(l.lengthOfLongestSubstring(" ")); //' '  = 1
        System.out.println(l.lengthOfLongestSubstring("a")); //a = 1
        System.out.println(l.lengthOfLongestSubstring("abba")); //ab or ba = 2
        System.out.println(l.lengthOfLongestSubstring("dvdf")); //vdf = 3
        System.out.println(l.lengthOfLongestSubstring("abcabcbb"));//abc = 3
        System.out.println(l.lengthOfLongestSubstring("bbbbb"));//b = 1
        System.out.println(l.lengthOfLongestSubstring("pwwkew"));//wke = 3
        System.out.println(l.lengthOfLongestSubstring("abcdeafbdgcbb"));//eafbdgc = 7
        System.out.println(l.lengthOfLongestSubstring("abcdeafbdgcbx"));//eafbdgc = 7
    }
}
