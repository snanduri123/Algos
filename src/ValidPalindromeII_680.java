/*
Given a string s, return true if the s can be palindrome after deleting at most one character from it.



Example 1:

Input: s = "aba"
Output: true
Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
Example 3:

Input: s = "abc"
Output: false


Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
 */

public class ValidPalindromeII_680 {

    //Two Pointers
    //Time :O(n)
    //Space:O(1)

    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
            i++;
            j--;
        }
        return true;
    }

    //standard palindrome checking by iteration.
    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindromeII_680 v = new ValidPalindromeII_680();
        System.out.println(v.validPalindrome("aba")); //true //no deletions
        System.out.println(v.validPalindrome("babad")); //false  //needs 2 deletion to get palindrome.
        System.out.println(v.validPalindrome("abca")); //true  //needs 1 deletion to get palindrome.
    }
}
