import java.util.HashMap;
import java.util.Map;

/*Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false


Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 */

public class Anagram_242 {

    //using hashmap
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length())
            return false;
        else {
            Map<Character, Integer> count = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                count.put(s.charAt(i), 1 + count.getOrDefault(s.charAt(i), 0));
                count.put(t.charAt(i), count.getOrDefault(t.charAt(i), 0) - 1);
            }

            for (Integer occurance : count.values()) {
                if (occurance != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    //using array
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        else {
            int[] arr = new int[26];
            for (int i = 0; i < s.length(); i++) {
                arr[s.charAt(i) - 'a'] += 1; //or   chArr[s.charAt(i)-'a']++;
                arr[t.charAt(i) - 'a'] -= 1; //or   chArr[t.charAt(i)-'a']--;
            }

            for (int i : arr) {
                if (i != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Anagram_242 t = new Anagram_242();
        System.out.println(t.isAnagram("anagram", "nagaram")); //true
        System.out.println(t.isAnagram("rat", "cat")); //false
        System.out.println(t.isAnagram("anagra", "nagaram")); //false
    }
}
