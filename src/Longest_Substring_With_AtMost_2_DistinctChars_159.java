/*
Given a string s, return the length of the longest
substring
 that contains at most two distinct characters.



Example 1:

Input: s = "eceba"
Output: 3
Explanation: The substring is "ece" which its length is 3.
Example 2:

Input: s = "ccaabbb"
Output: 5
Explanation: The substring is "aabbb" which its length is 5.


Constraints:

1 <= s.length <= 105
s consists of English letters.
 */

import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_With_AtMost_2_DistinctChars_159 { //Medium

    //Time: O(n)
    //Space: O(1)
    //Two pointers (start, end) both begin from the beginning. end iterates over each character in the string.
    // whenever there is valid (within window) duplicate, start is updated to  oldduplicate's position + 1;
    public int lengthOfLongestSubstringTwoDistinct1(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        int start = 0;
        int i = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            if(map.size() < 2){  // if map size is < 2 then just add or update the map with the current char.
                map.put(c, map.getOrDefault(c,0) +1 );
                i++;
            }else{ //already 2 elements are in the map
                if(map.containsKey(c)){ //if duplicate char in the map then increase its frequency
                    map.put(c, map.get(c) + 1);
                    i++;
                }else{ //1.if new character then decrease the frequency of previous start pointer char. If that char's frequency becomes 0 then remove it so that size will become < 2 so that the current new character can be added in next iteration. 2.INCREMENT the start pointer and do not move "i" pointer.
                    map.put(s.charAt(start), map.get(s.charAt(start)) -1);
                    if(map.get(s.charAt(start)) ==0){
                        map.remove(s.charAt(start));
                    }
                    start++;
                }
            }
            maxLen = Math.max(maxLen, i-start);
        }
        return  maxLen;
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        int start = 0;
        int i = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            if(map.size() > 2) {
                if(map.containsKey(c)){
                    map.put(c, map.get(c) +1 );
                    i++;
                }
                else {
                    map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                    if (map.get(s.charAt(start)) == 0) {
                        map.remove(s.charAt(start));
                    //    i++;
                    }
                    start++;
                }
            }else{
                map.put(c, 1 );
                i++;
            }
            maxLen = Math.max(maxLen, i-start);
        }
        return  maxLen;
    }

    public static void main(String[] args) {
        Longest_Substring_With_AtMost_2_DistinctChars_159 l = new Longest_Substring_With_AtMost_2_DistinctChars_159();
//        System.out.println(l.lengthOfLongestSubstringTwoDistinct("eceba")); //"ece" = 3
//        System.out.println(l.lengthOfLongestSubstringTwoDistinct("ccaabbb")); //"aabbb" = 5
//        System.out.println(l.lengthOfLongestSubstringTwoDistinct("abcabcabc")); //"ab" or " bc" or "ca" = 2
        System.out.println(l.lengthOfLongestSubstringTwoDistinct("ababffzzeee")); // 5
    }
}
