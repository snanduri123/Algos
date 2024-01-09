package practice;

import java.util.HashMap;

public class LongestStringWithoutRepeatingCharacters {
    //Time: O(n)
    //Space: O(1)
    //Two pointers (start, end) both begin from the beginning. end iterates over each character in the string.
    // whenever there is valid (within window) duplicate, start is updated to  oldduplicate's position + 1;
    public int lengthOfLongestSubstring(String s) {

        int maxLen = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int start=0, end=0; end < s.length(); end++ ){
            if(map.containsKey(s.charAt(end))){
                int prevPos = map.get(s.charAt(end));
                if(prevPos >= start){  // if previous occurrence (duplicate) is in the window of current substring then do not include current character in finding length
                    maxLen = Math.max(maxLen, end-start);
                    start = prevPos + 1; //******* new start is DuplicatePrevPos + 1 *********
                }else{    // if previous occurrence is not in the current substring window then include current character for finding length
                    maxLen = Math.max(maxLen, end-start + 1);  //include curr element in the length. Eg: abba
                }    // first "ab"(len =2) is calculated, and then new substring starts at second b(idx=2) and when you see again a, the length should be calculated from only newSubstring start idx and ignore old occurrence of a.
            }
            else{ //Eg: input is just "abcd". No duplicates are found at every index then you always keep tracking the maxLength by including current index character.
                maxLen = Math.max(maxLen, end-start + 1);
            }
            map.put(s.charAt(end), end); //current element is always added to map (irrespective of having duplicate or being a new one)
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestStringWithoutRepeatingCharacters l = new LongestStringWithoutRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstring(" ")); //' '  = 1
        System.out.println(l.lengthOfLongestSubstring("a")); //a = 1
        System.out.println(l.lengthOfLongestSubstring("abba")); //ab or ba = 2
        System.out.println(l.lengthOfLongestSubstring("dvdf")); //vdf = 3
        System.out.println(l.lengthOfLongestSubstring("abcabcbb"));//abc = 3
        System.out.println(l.lengthOfLongestSubstring("bbbbb"));//b = 1
        System.out.println(l.lengthOfLongestSubstring("pwwkew"));//wke = 3
        System.out.println(l.lengthOfLongestSubstring("abcdeafbdgcbb"));//eafbdgc = 7
    }
}
