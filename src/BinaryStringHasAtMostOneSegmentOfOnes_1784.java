/*
Given a binary string s without leading zeros, return true if s contains at most one contiguous segment of ones. Otherwise, return false.



Example 1:

Input: s = "1001"
Output: false
Explanation: The ones do not form a contiguous segment.
Example 2:

Input: s = "110"
Output: true


Constraints:

1 <= s.length <= 100
s[i] is either '0' or '1'.
s[0] is '1'.
Accepted
33.9K
Submissions
 */

public class BinaryStringHasAtMostOneSegmentOfOnes_1784 {

    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }

    //Time : O(n)
    //Space: O(1)
    public boolean checkOnesSegment2(String s) {

        boolean zeroFoundBetween = false;
        for(char c : s.toCharArray()){
            if(c == '0'){
                zeroFoundBetween = true;
            }
            else if(zeroFoundBetween && c == '1'){
                return false;
            }
        }
        return true;
    }
}
