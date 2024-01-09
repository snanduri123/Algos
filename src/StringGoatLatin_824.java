/*
ou are given a string sentence that consist of words separated by spaces. Each word consists of lowercase and uppercase letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.) The rules of Goat Latin are as follows:

If a word begins with a vowel ('a', 'e', 'i', 'o', or 'u'), append "ma" to the end of the word.
For example, the word "apple" becomes "applema".
If a word begins with a consonant (i.e., not a vowel), remove the first letter and append it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".
Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
For example, the first word gets "a" added to the end, the second word gets "aa" added to the end, and so on.
Return the final sentence representing the conversion from sentence to Goat Latin.



Example 1:

Input: sentence = "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
Example 2:

Input: sentence = "The quick brown fox jumped over the lazy dog"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"


Constraints:

1 <= sentence.length <= 150
sentence consists of English letters and spaces.
sentence has no leading or trailing spaces.
All the words in sentence are separated by a single space.
 */

import java.util.Arrays;
import java.util.HashSet;

public class StringGoatLatin_824 {


    //Time: O(n)
    //Space: O(n)
    public String toGoatLatin(String sentence) {

        StringBuilder ans = new StringBuilder();
        String[] arr = sentence.split(" ");
        int idx = 1;
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u', 'A','E','I','O','U'));

        for(String word : arr){
            StringBuilder newWord = new StringBuilder(word);

            if(!vowels.contains(word.charAt(0))){
                newWord.deleteCharAt(0);
                newWord.append(word.charAt(0));
            }
            newWord.append("ma");

            int cnt =0;
            while(cnt < idx){
                newWord.append("a");
                cnt++;
            }
            idx++;
            ans.append(newWord);
            ans.append(" ");
        }

        ans.deleteCharAt(ans.length()-1);
        return ans.toString();
    }

    public static void main(String[] args){
        StringGoatLatin_824 s = new StringGoatLatin_824();
        System.out.println(s.toGoatLatin(new String("I speak Goat Latin"))); //"Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
        System.out.println(s.toGoatLatin(new String("The quick brown fox jumped over the lazy dog"))); //"heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa
    }
}
