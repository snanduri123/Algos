/*
Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]
*/
public class Reverse_String_II_541 {

//    public String reverseStr(String s, int k) {
//
//
//
//    }

    public String reverseStr(String s, int k, int i) {

     if(i <= k - 2) {
         String subString = s.substring(i,i+2);
         s = subString.charAt(1) + subString.charAt(0) + s.substring(i+2, s.length());
         return reverseStr(s,k, i+2);
     }
     return s;
    }
}
