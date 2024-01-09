/*
Given a character array s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by a single space.

Your code must solve the problem in-place, i.e. without allocating extra space.



Example 1:

Input: s = ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
Example 2:

Input: s = ["a"]
Output: ["a"]


Constraints:

1 <= s.length <= 105
s[i] is an English letter (uppercase or lowercase), digit, or space ' '.
There is at least one word in s.
s does not contain leading or trailing spaces.
All the words in s are guaranteed to be separated by a single space.

 */

import java.util.Arrays;

public class Reverse_Words_in_a_String_II_186 {
    //Time: O(n)
    //Space : O(1)
    public char[] reverseWords(char[] s) {
        int start = 0;
        int end = s.length - 1;
        reverse(s, start, end);
        for (int i = 0; i < end; i++) {
            start = i;
            while (i <= end && s[i] != ' ') {
                i++;
            }  //i is pointing to a space. word before that space is reversed and i++ will skip the space keeping it unchanged.
            reverse(s, start, i - 1);
        }
        return s;
    }
    public void reverse(char[] s, int start, int end) {
        while (start < end) { //reverse entire string
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        Reverse_Words_in_a_String_II_186 r = new Reverse_Words_in_a_String_II_186();
        System.out.println(r.reverseWords(new char[]{'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'})); //'blue is sky the'

    }
}
