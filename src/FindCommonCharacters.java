import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.



Example 1:

Input: words = ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: words = ["cool","lock","cook"]
Output: ["c","o"]


Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists of lowercase English letters.

 */
public class FindCommonCharacters {

    //Time complexity - O(n)
    //Space complexity - O(1)
    public List<String> commonChars(String[] words) {

        List<String> commonCharList = new ArrayList<String>();
        int[] commonChCount = new int[26];
        Arrays.fill(commonChCount, Integer.MAX_VALUE);
        for(String word : words) {
            int[] wordChCount = new int[26];
            word.chars().forEach(c -> ++wordChCount[c - 'a']);
            for(int i = 0; i< 26; i++){
                commonChCount[i] = Math.min(commonChCount[i], wordChCount[i]);
            }
        }

        for(int i = 0; i < 26 ; i++){
            if (commonChCount[i] > 0) {
                int freq = 1;
                while (freq <= commonChCount[i]) {
                    commonCharList.add(String.valueOf((char) ('a' + i)));
                    freq++;
                }
            }
        }

        return commonCharList;
    }

        //*more precise coding of above approach
    //    public List<String> commonChars(String[] A) {
//        List<String> ans = new ArrayList<>();
//        int[] count = new int[26];
//        Arrays.fill(count, Integer.MAX_VALUE);
//        for (String str : A) {
//            int[] cnt = new int[26];
//            str.chars().forEach(c -> ++cnt[c - 'a']); // count each char's frequency in string str.
//            for (int i = 0; i < 26; ++i) { count[i] = Math.min(cnt[i], count[i]); } // update minimum frequency.
//        }
//        for (char c = 'a'; c <= 'z'; ++c) {
//            while (count[c - 'a']-- > 0) { ans.add("" + c); }
//        }
//        return ans;
//    }

    public static void main(String[] args){
        FindCommonCharacters f = new FindCommonCharacters();

        System.out.println(f.commonChars(new String[]{"bella","label","roller"})); //["e","l","l"]
//        System.out.println(f.commonChars(new String[]{"cool","lock","cook"})); // ["c","o"]
//        System.out.println(f.commonChars(new String[]{"bela","label","roller"})); //["e","l"]
//        System.out.println(f.commonChars(new String[]{"bela","crocs","right"})); //[]
    }
}

