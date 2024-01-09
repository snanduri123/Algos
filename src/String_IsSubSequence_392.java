/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).



Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false


Constraints:

0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.


Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?

 */

public class String_IsSubSequence_392 {
    //Time: O(s) + O(t)
    //Space: O(1)
    //TIP: whenever subsequence or contiguous comes then use 2 pointers or two pointers
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) { // if a char is found in s then move to next char.
                i++;
            }
            j++; // no matter char found in t, go to next char.
        }

        // return i == s.length();

        if (i < s.length() && j >= t.length()) // if all chars in s are not searched but chars in t are already visited then it is not subsequence.
            return false;

        return true;
    }

    public static void main(String[] args){
        String_IsSubSequence_392 s = new String_IsSubSequence_392();
        System.out.println(s.isSubsequence("abc", "ahbgdc")); //true
        System.out.println(s.isSubsequence("axc", "ahbgdc")); //false
        System.out.println(s.isSubsequence("ab", "baab")); //true
    }
}
