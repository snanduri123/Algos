/*
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.



Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.


Constraints:

1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.
 */
public class Find_Index_of_FirstOccurrence_Of_String_28 {
    public int strStr(String haystack, String needle) {
        for(int idx = 0 ; idx<= haystack.length() - needle.length(); ){ //idx to track the actual char of haystack
            int i = idx;  //i to iterate and compare haystack char with needle char.
            int j = 0;  //j to iterate needle char.
            while(j < needle.length()){
                if(haystack.charAt(i) == needle.charAt(j)){
                    i++;
                    j++;
                }else{
                    break;
                }
            }
            if(j == needle.length())
                return i - needle.length();
            else
                idx++;
        }
        return -1;
    }

    public static void main(String[] args){
        Find_Index_of_FirstOccurrence_Of_String_28 f = new Find_Index_of_FirstOccurrence_Of_String_28();
        System.out.println(f.strStr("sadbutsad", "sad")); // 0  (0 and 6 but 0 is first)
        System.out.println(f.strStr("leetcode", "leeto")); // -1
        System.out.println(f.strStr("hello", "ll")); // 2
        System.out.println(f.strStr("a", "a")); // 0
        System.out.println(f.strStr("mississippi", "issip")); // 4

    }
}
