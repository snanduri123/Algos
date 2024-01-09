/*
You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.

Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.

Return true if a and b are alike. Otherwise, return false.



Example 1:

Input: s = "book"
Output: true
Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.
Example 2:

Input: s = "textbook"
Output: false
Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
Notice that the vowel o is counted twice.


Constraints:

2 <= s.length <= 1000
s.length is even.
s consists of uppercase and lowercase letters.
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringHalvesAlike_1704 {

    public boolean halvesAreAlike(String s) {

        Set<Character> vowels = new HashSet<>(Arrays.asList('A','E','I','O','U','a','e','i','o','u'));
        int left = 0;
        int right = 0;

        for(int i=0, j=s.length()/2; j<s.length(); i++,j++){
            if(vowels.contains(s.charAt(i)))
                left++;
            if(vowels.contains(s.charAt(j)))
                right++;
        }
        return left == right ? true : false;
    }

    public static void main(String[] args){
        StringHalvesAlike_1704 s = new StringHalvesAlike_1704();
        System.out.println(s.halvesAreAlike("book")); //true
        System.out.println(s.halvesAreAlike("textbook")); //false
    }
}


