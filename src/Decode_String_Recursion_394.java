/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.



Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"


Constraints:

1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].
 */

/*
We use a counter i to keep track of our progress in string s and recursively calculate
 subproblems quoted by [].
 */
public class Decode_String_Recursion_394 {  //Medium (backtracking using recursion)
    int i =0;
    public String decodeString( String s) {

        StringBuilder sb = new StringBuilder();
        int num = 0;

        while (i < s.length()) {

            char ch = s.charAt(i);
            i++; //increment i and keep it ready for next char that has to be evaluated. So even when you come out of recursion this value shows fromw where you need to evaluate.

            if (ch == '[') { //get the string within [] using recursion and then replicate it as many times  as num.
                String stringInRecur = decodeString(s);
                for (int j = 0; j < num; j++) {  // 3["ab"] --> ababab
                    sb.append(stringInRecur);
                }
                num = 0;  // num resets to 0.
            }
            else if (ch == ']') {  //recursion/sub problem ends. The stack (in which this break happens) will go to return statement and returns the sofar calculated sb.
                break;
            }
            else if (Character.isDigit(ch)) {  // if curr char is a number then convert it to number (by subtracting '0') and append to right of the already existing number
                num = num * 10 + (ch - '0');  //s= 12[a].  num= 2(already seen and calculated);  now ch = 3 (ascii=33) ==> 2 *10 + (33 - 30) = 23.
            } else {  //just character
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Decode_String_Recursion_394 d1 = new Decode_String_Recursion_394();
        System.out.println(d1.decodeString("3[a]2[bc]")); //"aaabcbc"

        Decode_String_Recursion_394 d2 = new Decode_String_Recursion_394();
        System.out.println(d2.decodeString("3[a2[c]]")); //"accaccacc"

        Decode_String_Recursion_394 d3 = new Decode_String_Recursion_394();
        System.out.println(d3.decodeString("2[abc]3[cd]ef")); //"abcabccdcdcdef"

    }
}
