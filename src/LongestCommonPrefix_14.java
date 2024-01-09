/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix amongst the input strings.

*/

public class LongestCommonPrefix_14 {

    // Time complexity : O(n)
    //Space complexity: O(1)
    //using string builder
    public String longestCommonPrefix_Orginal(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder commonPrefix = new StringBuilder();
        for(int i = 1 ; i < strs[0].length(); i++){   //take first string in the array to compare with other strings.
            char temp = '\u0000';
            for(String str: strs){
                if(i >= str.length())         // if any of the string's index reached out of bound then break and return so far computed prefix
                    return new String(commonPrefix);
                if(temp == '\u0000') {       // setting temp character to char in first string to compare with all other strings.
                    temp = str.charAt(i);
                }
                if(str.charAt(i) != temp)     // if a character is not common in all strings at the same index then return so far computed prefix
                    return new String(commonPrefix);
            }
            commonPrefix.append(strs[0].charAt(i));
        }
        return new String(commonPrefix);
    }
    public String longestCommonPrefix(String[] strs){
        StringBuilder ans = new StringBuilder();
        int minLength = Integer.MAX_VALUE;
        String minString = null;
        for(String str : strs){  //find smallest length string
            if (str.length() < minLength){
                minLength = str.length();
                minString = str;
            }
        }
        for(int i=0; i< minLength; i++){  //check every character of a string with min string
            for(String str : strs){
                if (!str.equals(minString)){ //find common prefix for all strings except the min string
                    if(str.charAt(i) != minString.charAt(i))
                        return new String(ans);
                }
            }
            ans.append(minString.charAt(i)); //every common char in all strings is appended to the answer.
        }
        return new String(ans);
    }

    public static void main(String[] args){
        LongestCommonPrefix_14 lcp = new LongestCommonPrefix_14();
        System.out.println(lcp.longestCommonPrefix(new String[] {"flower", "flow", "flight"})); //fl
        System.out.println(lcp.longestCommonPrefix(new String[] {"doc", "car", "rat"})); //empty
        System.out.println(lcp.longestCommonPrefix(new String[] {"struck", "strike", "strung"})); //str
    }
}
