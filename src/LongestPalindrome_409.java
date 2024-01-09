/*
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.



Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.


Constraints:

1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.
 */

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome_409 {

    //Time: O(n)
    //Space: O(K) //26 letters

    public int longestPalindrome(String s) {

        int ans = 0;
        int singleChars = 0;

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0; i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }

        for(Map.Entry<Character,Integer> pair : map.entrySet()){
            if(pair.getValue()%2 ==0){  //if a char count is even then all its occurances can be used for palindrom
                ans += pair.getValue();
            }
            else if(pair.getValue() > 2){  //if a char count is odd and > 2 then except 1 occurance all can be used for palindrome.
                ans += pair.getValue()-1;
                singleChars++;  //increment that one left out single character.
            }
            else{  //if there is a char of count 1.
                singleChars++;
            }

        }

        if(singleChars > 0){  //If there are any single characters then one of them can be used in the middle of palindrome.
            ans +=1;
        }
    return ans;
    }

    public static void main(String[] args){
        LongestPalindrome_409 l = new LongestPalindrome_409();
        System.out.println(l.longestPalindrome("abccccdd")); //7 "dccaccd" or "dccbccd"
        System.out.println(l.longestPalindrome("a"));//1 "a"
        System.out.println(l.longestPalindrome("abccccddeee")); //9 "edccaccde" or "edcceccde" or "edccbccde"
        System.out.println(l.longestPalindrome("accccddeeeeeee")); //13 "eeedccaccdeee" or "eeedcceccdeee"

    }
}
