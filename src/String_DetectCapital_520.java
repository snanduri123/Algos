/*
We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Given a string word, return true if the usage of capitals in it is right.



Example 1:

Input: word = "USA"
Output: true
Example 2:

Input: word = "FlaG"
Output: false


Constraints:

1 <= word.length <= 100
word consists of lowercase and uppercase English letters.
 */

import java.util.Stack;

public class String_DetectCapital_520 {

    public boolean detectCapitalUse(String word) {

        if(word.equals(word.toLowerCase()) || word.equals(word.toUpperCase()))
            return true;

        if(word.substring(1).equals(word.substring(1).toLowerCase()))
            return true;
        else
            return false;

    }

    public static void main(String[] args){
        String_DetectCapital_520 s = new String_DetectCapital_520();
        System.out.println(s.detectCapitalUse("leetcode")); //true
        System.out.println(s.detectCapitalUse("USA")); //true
        System.out.println(s.detectCapitalUse("Google")); //true
        System.out.println(s.detectCapitalUse("uSA")); //false
    }
}
