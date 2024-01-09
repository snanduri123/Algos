import java.util.HashMap;
import java.util.Map;
/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
 */

//Time : O(n) : space : n
public class WordPattern_290 {


    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");

        if(pattern.length() != words.length)
            return false;

        HashMap<String, String> map = new HashMap<>();

        for(int i=0; i < pattern.length(); i++){
            String key = String.valueOf(pattern.charAt(i));
            if(map.containsKey(key)) {
                if (!words[i].equals(map.get(key)))
                    return false;
            }
           else{
               if(map.containsValue(words[i]))
                         return false;
                    map.put(key, words[i]);
            }
        }
        return true;
    }

    public static void main(String[] args){
        WordPattern_290 w = new WordPattern_290();
//        System.out.println( w.wordPattern("abba", "dog cat cat dog"));
        System.out.println( w.wordPattern("abba", "dog cat cat fish"));
//        System.out.println( w.wordPattern("aaaa", "dog cat cat dog"));
//        System.out.println( w.wordPattern("abba", "dog dog dog dog"));

    }
}
