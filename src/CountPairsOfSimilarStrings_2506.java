/*
You are given a 0-indexed string array words.

Two strings are similar if they consist of the same characters.

For example, "abca" and "cba" are similar since both consist of characters 'a', 'b', and 'c'.
However, "abacba" and "bcfd" are not similar since they do not consist of the same characters.
Return the number of pairs (i, j) such that 0 <= i < j <= word.length - 1 and the two strings words[i] and words[j] are similar.



Example 1:

Input: words = ["aba","aabb","abcd","bac","aabc"]
Output: 2
Explanation: There are 2 pairs that satisfy the conditions:
- i = 0 and j = 1 : both words[0] and words[1] only consist of characters 'a' and 'b'.
- i = 3 and j = 4 : both words[3] and words[4] only consist of characters 'a', 'b', and 'c'.
Example 2:

Input: words = ["aabb","ab","ba"]
Output: 3
Explanation: There are 3 pairs that satisfy the conditions:
- i = 0 and j = 1 : both words[0] and words[1] only consist of characters 'a' and 'b'.
- i = 0 and j = 2 : both words[0] and words[2] only consist of characters 'a' and 'b'.
- i = 1 and j = 2 : both words[1] and words[2] only consist of characters 'a' and 'b'.
Example 3:

Input: words = ["nba","cba","dba"]
Output: 0
Explanation: Since there does not exist any pair that satisfies the conditions, we return 0.


Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consist of only lowercase English letters.
 */


import java.util.HashSet;
import java.util.Set;

public class CountPairsOfSimilarStrings_2506 {

    //Time : O(n2)
    //Space: O(1)
    public int similarPairs(String[] words) {

        int totPairs =0;

        for(int i =0; i< words.length -1 ; i++) {
            Set<Character> set1 = new HashSet<>();
            int pair = 0;
            for(char c : words[i].toCharArray()){
                set1.add(c);
            }
            for(int j= i+1; j< words.length; j++){
                Set<Character> set2 = new HashSet<>();
                for(char c : words[j].toCharArray()){
                    set2.add(c);
                }
                if(set1.containsAll(set2) && set2.containsAll(set1)) {
                    pair = pair + 1;
                }
            }
            totPairs = totPairs + pair;
        }
        return totPairs;
    }

    public static void main(String[] args){
        CountPairsOfSimilarStrings_2506 c = new CountPairsOfSimilarStrings_2506();
        System.out.println(c.similarPairs(new String[] {"aba","aabb"})); //1 ;
        System.out.println(c.similarPairs(new String[] {"aba","aabb","abcd","bac","aabc"})); //2 ; {words[0], words[1]}, {words[3] and words[4] }
        System.out.println(c.similarPairs(new String[] {"aabb","ab","ba"})); //3  {words[0], words[1]}, {words[1], words[2]}, {words[0], words[2]}
        System.out.println(c.similarPairs(new String[] {"nba","cba","dba"}));//0
    }
}
