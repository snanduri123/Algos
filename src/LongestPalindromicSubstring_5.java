/*
Given a string s, return the longest palindromic substring in s.



Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"


Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
 */

public class LongestPalindromicSubstring_5 {  //Medium

    int maxPalLength = 0;
    int start = 0;

    //Time: O(n^2)  - n (first for loop) *  n(while loop)
    //Space: O(1)
    public String longestPalindrome(String s) {

        if(s.length() < 2)
            return s;

        for(int idx=0; idx<s.length()-1; idx++) {
            checkPalindromeExtn(idx, idx, s); //if odd string then every idx is center
            checkPalindromeExtn(idx, idx+1, s); //if even string then every idx and idx+1 is center
        }
        return s.substring(start, start+maxPalLength);
    }

    public void checkPalindromeExtn(int i, int j, String s){
        //keep extending on both sides from center until it is not palindrome
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;  //extend left side
            j++;  //extend right side
        }

        //once i, j are no more equal to be palindromic then calculate the palindrome seq length uptil then
        //Eg: String:   a e b b c d -> b b
        //    index:    0 1 2 3 4 5 -> 2 3 (length = 2)
        //when control reaches below line  i = 1, j= 4 (s[i] <> s[j] => no more palindromic)
        //    so  len = 4 - 1 - 1 = 2
        if(maxPalLength < j - i - 1 ){
            start = i + 1;   //update the start index of the palindrome
            maxPalLength = j - i - 1;  //update the maxLength
        }

    }

    //Time: O(n3) 2 nested for loops n^2 and one loop (n) in helper method.
    //Space: O(1)
//    public String longestPalindrome_nCube(String s) {
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = s.length()-1; j >0; j-- ) {
//                if(isPalindrome( i,  j,  s)){
//                    return s.substring(i,j+1);
//                }
//            }
//        }
//        return "";
//    }
//
//    public boolean isPalindrome(int i, int j, String s) {
//
//        while (i < j) {
//            if (s.charAt(i) == s.charAt(j)) {
//                i++;
//                j--;
//            } else {
//                return false;
//            }
//        }
//        return true;
//    }


    public static void main(String[] args){
        LongestPalindromicSubstring_5 l1 = new LongestPalindromicSubstring_5();
        System.out.println(l1.longestPalindrome("babad")); //bab or aba

        LongestPalindromicSubstring_5 l2 = new LongestPalindromicSubstring_5();
        System.out.println(l2.longestPalindrome("cbbd")); //bb

        LongestPalindromicSubstring_5 l3 = new LongestPalindromicSubstring_5();
        System.out.println(l3.longestPalindrome("ab")); //a

        LongestPalindromicSubstring_5 l4 = new LongestPalindromicSubstring_5();
        System.out.println(l4.longestPalindrome("adebb")); //bb

        LongestPalindromicSubstring_5 l5 = new LongestPalindromicSubstring_5();
        System.out.println(l5.longestPalindrome("aaebd")); //aa
    }
}
