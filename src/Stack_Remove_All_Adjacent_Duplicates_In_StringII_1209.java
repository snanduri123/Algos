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

public class Stack_Remove_All_Adjacent_Duplicates_In_StringII_1209 {

    //Time: O(n), n=length of string
    //Space: O(n)
    //using stack

     class CharCount{
         char ch;
         int count;
         public CharCount(char ch, int count){
             this.ch = ch;
             this.count = count;
         }
     }
    public String removeDuplicates(String s, int k) {

        Stack<CharCount> stack = new Stack<>();  //stack of custom object (char and its count)
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && (stack.peek().ch == c)) {  //if peek is same as curr then increment the count and remove peek if the count == k
                stack.peek().count++;
                if(stack.peek().count == k){
                    stack.pop();
                }
            } else {
                CharCount charCount = new CharCount(c, 1); //if new element then add to stack with its count 1
                stack.push(charCount);
            }
        }

        StringBuilder result = new StringBuilder();
        for(CharCount  cc : stack){  //get elements from stack from bottom to top.
            while(cc.count >0) {   //append as many times as its count.
                result = result.append(cc.ch);
                cc.count--;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Stack_Remove_All_Adjacent_Duplicates_In_StringII_1209 R = new Stack_Remove_All_Adjacent_Duplicates_In_StringII_1209();
        System.out.println(R.removeDuplicates("abcd",2)); //abcd - nothing to delete
        System.out.println(R.removeDuplicates("deeedbbcccbdaa", 3)); //aa
        System.out.println(R.removeDuplicates("pbbcggttciiippooaais", 2)); //ps
    }
}
