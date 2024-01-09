/*
Given a string s, partition s such that every
substring
 of the partition is a
palindrome
. Return all possible palindrome partitioning of s.



Example 1:

Input: s = "abracadabra"
Output: ["a|b|r|a|c|ada|b|r|a", "a|b|r|aca|d|a|b|r|a", "a|b|r|a|c|a|d|a|b|r|a"]

Example 2:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]


Example 3:

Input: s = "a"
Output: [["a"]]


Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Palindrome_Partitioning_131 {

    static int[][] isPalindromeDP;

    public List<List<String>> partition(String s) {
        isPalindromeDP = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(isPalindromeDP[i], -1);
        }
        return partitionPalindrome(s, 0);
    }

    public List<List<String>> partitionPalindrome(String s, int pos) {

        List<List<String>> allSuffixPartitions = new ArrayList<>();

        if (pos == s.length()) {
            List<String> str = new ArrayList<>();
            allSuffixPartitions.add(str);
            return allSuffixPartitions;
        }


        for (int i = pos; i < s.length(); i++) {
            if (isPalindrome(s, pos, i)) {
                List<List<String>> suffixPartitions = partitionPalindrome(s, i + 1);

                if (suffixPartitions.size() != 0) {
                    for (List<String> suffixPartition : suffixPartitions) {
                        suffixPartition.add(0, s.substring(pos, i + 1));
                        allSuffixPartitions.add(suffixPartition);
                    }
                }
            }
        }
        return allSuffixPartitions;
    }

    public boolean isPalindrome(String s, int start, int end) {

        if(isPalindromeDP[start][end] != -1){
            if (isPalindromeDP[start][end] == 1) {
                return true;
            }
            else{
                return false;
            }
        }
        while (start < end) {

            if (s.charAt(start) == s.charAt(end)) {
                start = start + 1;
                end = end - 1;
            } else {
                isPalindromeDP[start][end] = 0;
                return false;
            }
        }
        isPalindromeDP[start][end] = 1;
        return true;
    }

    public static void main(String[] args) {
        Palindrome_Partitioning_131 p = new Palindrome_Partitioning_131();
        System.out.println(Arrays.deepToString(p.partition("abracadabra").toArray()));//  str.add(String.valueOf(s.charAt(pos)));
        System.out.println(Arrays.deepToString(p.partition("aaa").toArray()));
    }
}
