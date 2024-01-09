/*
Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.


Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.


Constraints:

1 <= s.length <= 105
s[i] is either'(' , ')', or lowercase English letter.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

public class Stack_Minimum_Remove_To_Make_ValidParentheses_1249 {

    //Time: O(n), n=length of string
    //Space: O(n) + O(n)
    public String minRemoveToMakeValid(String s) {
        HashSet<Integer> extraBrackets = new HashSet<>();  //stores extra ) or  ( if they do not have pairing ( before their occurrence.
        Stack<Integer> stack = new Stack<>();  // tracks ( and removes them when pairing ) is found

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.add(i);
            }else if(s.charAt(i) == ')'){
                if(!stack.isEmpty() && s.charAt(stack.peek()) == '('){
                    stack.pop();
                }else{
                    extraBrackets.add(i);
                }
            }
        }
        while(!stack.isEmpty()){
            extraBrackets.add(stack.pop());
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(!extraBrackets.contains(i)){
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Stack_Minimum_Remove_To_Make_ValidParentheses_1249 R = new Stack_Minimum_Remove_To_Make_ValidParentheses_1249();
        System.out.println(R.minRemoveToMakeValid("lee(t(c)o)de")); //lee(t(c)o)de
        System.out.println(R.minRemoveToMakeValid("a)b(c)d")); //ab(c)d
        System.out.println(R.minRemoveToMakeValid("))((")); //""
    }
}
