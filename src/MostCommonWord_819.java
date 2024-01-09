/*
Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned. It is guaranteed there is at least one word that is not banned, and that the answer is unique.

The words in paragraph are case-insensitive and the answer should be returned in lowercase.



Example 1:

Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
Output: "ball"
Explanation:
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"),
and that "hit" isn't the answer even though it occurs more because it is banned.
Example 2:

Input: paragraph = "a.", banned = []
Output: "a"


Constraints:

1 <= paragraph.length <= 1000
paragraph consists of English letters, space ' ', or one of the symbols: "!?',;.".
0 <= banned.length <= 100
1 <= banned[i].length <= 10
banned[i] consists of only lowercase English letters.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MostCommonWord_819 {


    //Time: O(p) + o(b)
    //Space: O(p) + o(b)
    public String mostCommonWord(String paragraph, String[] banned) {

        String maxWord = null;
        int maxCount = Integer.MIN_VALUE;

        HashMap<String,Integer> paras = new HashMap<>();

        Set<String> ban = new HashSet<>();

        for(String word : banned){
            ban.add(word.toLowerCase());
        }

     //   String para = paragraph.replaceAll("[-+.^:,!@#$%^&*(){}]"," ").toLowerCase(); //did not work for "b,b,b,c"
        String para = paragraph.replaceAll("\\W+"," ").toLowerCase(); //replace everything that is not a word character and convert to lower case
        for(String word : para.split(" ")){
            paras.put(word, paras.getOrDefault(word.toLowerCase(),0) + 1);
            if(paras.get(word) > maxCount && !ban.contains(word)){
                maxWord = word;
                maxCount = paras.get(word);
            }
        }

        return maxWord;
    }


    public static void main(String[] args){
        MostCommonWord_819 m = new MostCommonWord_819();
        System.out.println(m.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"})); //ball
        System.out.println(m.mostCommonWord("Bob!", new String[]{"hit"})); //bob
        System.out.println(m.mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"})); //bob
    }
}
