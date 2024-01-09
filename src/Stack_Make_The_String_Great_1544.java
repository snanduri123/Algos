import java.util.Stack;

/*
Given a string s of lower and upper case English letters.

A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:

0 <= i <= s.length - 2
s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
To make the string good, you can choose two adjacent characters that make the string bad and remove them. You can keep doing this until the string becomes good.

Return the string after making it good. The answer is guaranteed to be unique under the given constraints.

Notice that an empty string is also good.



Example 1:

Input: s = "leEeetcode"
Output: "leetcode"
Explanation: In the first step, either you choose i = 1 or i = 2, both will result "leEeetcode" to be reduced to "leetcode".
Example 2:

Input: s = "abBAcC"
Output: ""
Explanation: We have many possible scenarios, and all lead to the same answer. For example:
"abBAcC" --> "aAcC" --> "cC" --> ""
"abBAcC" --> "abBA" --> "aA" --> ""
Example 3:

Input: s = "s"
Output: "s"


Constraints:

1 <= s.length <= 100
s contains only lower and upper case English letters.
*/
public class Stack_Make_The_String_Great_1544 {

    //Time : O(n)
    //Space: O(n)
    //using stack.
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty() && Math.abs(s.charAt(i) - stack.peek()) == 32){
                stack.pop();
            }
            else{
                stack.add(s.charAt(i));
            }
        }

        StringBuilder result = new StringBuilder();
        for(char c : stack){  // for each loop on stack and queue starts from index 0; so the order characters won't change
            result.append(c);
        }
        return result.toString();
    }

    //Time : O(n)
    //Space: O(n)
    //no extra memory to process.
    public String makeGood1(String s) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
//            if (result.length()!=0 && (result.charAt(result.length()-1) != c) &&
//                    ((Character.toUpperCase(result.charAt(result.length()-1)) == c) ||
//                            (Character.toLowerCase(result.charAt(result.length()-1)) == c))){
//                //result.replace(result.length() - 1, result.length(), ""); //remove the last letter
//                result.deleteCharAt(result.length() - 1);
//            }
            if (result.length() != 0 && (Math.abs(result.charAt(result.length() - 1) - c) == 32)) {
                result.deleteCharAt(result.length() - 1);
            } else
                result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Stack_Make_The_String_Great_1544 M = new Stack_Make_The_String_Great_1544();
        System.out.println(M.makeGood("leEeetcode")); //"leetcode"
        System.out.println(M.makeGood("abBAcC")); // ""
        System.out.println(M.makeGood("s")); // "s"
        System.out.println(M.makeGood("Pp")); // ""
    }


}
