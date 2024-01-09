/*
Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is
the smallest in lexicographical order
 among all possible results.



Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"


Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.

 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

public class Stack_Remove_Duplicate_Letters_316 {

    //Time: O(n), n=length of string
    //Space: O(1) At first glance it looks like this is O(N), but that is not true! seen will only contain unique elements,
    //      so it's bounded by the number of characters in the alphabet (a constant). You can only add to stack if an element has not been seen,
    //      so stack also only consists of unique elements. This means that both stack and seen are bounded by constant, giving us O(1) space complexity.
    public String removeDuplicateLetters(String s) {
        HashSet<Character> seen = new HashSet<>();  //stores the characters that are already seen
        Stack<Character> stack = new Stack<>();  // stores the order of answer lexicographically.
        Map<Character, Integer> charCount = new HashMap<>(); //store the occurrences of each character.
        for (int i = 0; i < s.length(); i++) {   //get count of each char
            charCount.put(s.charAt(i), charCount.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(char c : s.toCharArray()){

            charCount.put(c, charCount.get(c) -1);  //reduce the count by 1 as it is being used now.

            //Eg:1. "acdbad". currstack = acdb, now new a can't be added because it is already seen then it must be already in the stack at its place according to lexicographical order.
            //Eg:2. "acdbcb". currstack = acdb, now another c can't be added because b < new c.
            //Eg:3. "cdbad".  currstack = cdb, now a can't remove b because there is no more b after this a.
            //Eg:4. "cdbadb".  currstack = cdb, now a can remove db because there are more b and d after this a.
            if(!seen.contains(c)) {
                while (!stack.isEmpty() &&
                        (stack.peek() > c && charCount.get(stack.peek()) > 0)){  //if peek char is bigger than curr char and is having more occurrences, then remove it from the stack so that the other occurrences can be used later as per lexographic order.
                    char ch = stack.pop(); //remove from stack
                    seen.remove(ch);  //remove from set.
                }
                stack.add(c);
                seen.add(c);
            }
        }

        StringBuilder result = new StringBuilder();
        for(char c : stack){  //get elements from stack from bottom to top. (do not use stack.pop() in while loop, bcoz it will give elements from top to bottom and then we have to reverse the string at the end)
            result = result.append(c);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Stack_Remove_Duplicate_Letters_316 R = new Stack_Remove_Duplicate_Letters_316();

   //     System.out.println(R.removeDuplicateLetters("bcabc")); //abc
        System.out.println(R.removeDuplicateLetters("cbacdcbc")); //acdb
    }
}
