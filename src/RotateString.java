/*
Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.


Example 1:

Input: s = "abcde", goal = "cdeab"
Output: true
Example 2:

Input: s = "abcde", goal = "abced"
Output: false


Constraints:

1 <= s.length, goal.length <= 100
s and goal consist of lowercase English letters.
 */

public class RotateString {

    //Time: O(n)
    //Space: O(1)
    public boolean rotateString(String s, String goal) {

        if(s.length() != goal.length()){
            return false;
        }
        for(int i =0; i<s.length(); i++){

            //Take the string and split at each char and append the prefix to suffix tail and
            // check if the new string is same as goal.
            if((s.substring(i,s.length()) + s.substring(0,i)).equals(goal))
                return true;
        }
        return false;
    }

}
