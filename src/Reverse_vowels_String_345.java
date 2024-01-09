/*
Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.



Example 1:

Input: s = "hello"
Output: "holle"
Example 2:

Input: s = "leetcode"
Output: "leotcede"


Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Reverse_vowels_String_345 {

    //Time: O(n)
    //Space: O(k)
    public String reverseVowels(String s) {

        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        char[] str = s.toCharArray();

        for(int i =0, j=s.length()-1; i <j;){
            if(!vowels.contains(str[i])){
                i++;
            }
            else if(!vowels.contains(str[j])){
                j--;
            }
            else{
                if(str[i] != str[j]) { // if both letters are vowels and not same then only swap
                    char temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
                i++;
                j--;
            }
        }
        return String.valueOf(str);
    }

}
