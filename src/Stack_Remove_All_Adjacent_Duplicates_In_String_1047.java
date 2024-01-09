/*
You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.



Example 1:

Input: s = "abbaca"
Output: "ca"
Explanation:
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
Example 2:

Input: s = "azxxzy"
Output: "ay"


Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
 */

import java.util.Stack;

public class Stack_Remove_All_Adjacent_Duplicates_In_String_1047 {


    //Time: O(n), n=length of string
    //Space: O(n)
    //using string builder
    public String removeDuplicates2(String S) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for(char character : S.toCharArray()) {
            if (sbLength != 0 && character == sb.charAt(sbLength - 1))
                sb.deleteCharAt(sbLength-- - 1);
            else {
                sb.append(character);
                sbLength++;
            }
        }
        return sb.toString();
    }
    //Time: O(n), n=length of string
    //Space: O(n)
    //using stack
    public String removeDuplicates(String s) {
       // String resultStr = "";
        StringBuilder result = new StringBuilder(); // to not create multiple strings created while result is constructed from stack ( as string is immutable).
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && (stack.peek() == c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
//        while (!stack.isEmpty()) {  //using while loop to get elements from top to bottom of stack
//            result = result.insert(0, stack.pop()); // to get characters in the input order
//        }


        for(char c : stack){  //get elements from stack from bottom to top.
           result = result.append(c);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Stack_Remove_All_Adjacent_Duplicates_In_String_1047 R = new Stack_Remove_All_Adjacent_Duplicates_In_String_1047();

        System.out.println(R.removeDuplicates("abbaca")); //ca
        System.out.println(R.removeDuplicates("azxxzy")); //ay
        System.out.println(R.removeDuplicates("aaaaa")); //a
        System.out.println(R.removeDuplicates("aaaa")); // "empty"
    }
}
