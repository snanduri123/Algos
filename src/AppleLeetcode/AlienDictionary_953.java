package AppleLeetcode;

import java.util.HashMap;


    /*
    In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.



Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).


Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 20
order.length == 26
All characters in words[i] and order are English lowercase letters.
*/


public class AlienDictionary_953 {

    public boolean isAlienSorted(String[] words, String order) {

        if (words.length < 2) {
            return true;
        }
        // alien language alphabet order - k,v (char, its order pos)
        HashMap<Character, Integer> map = new HashMap<>();
        int val = 0;
        for (char ch : order.toCharArray()) {
            map.put(ch, ++val);
        }
        //compare curr word order with prev word.
        for (int i = 1; i < words.length; i++) {
            String currWord = words[i];
            String prevWord = words[i - 1];
            if (currWord.length() < prevWord.length() && prevWord.startsWith(currWord)) {
                return false; // prevword: apple , currword: app
            }
            for (int pos = 0; pos < prevWord.length() && pos < currWord.length(); ) {
                if (map.get(prevWord.charAt(pos)) > map.get(currWord.charAt(pos))) { //curr word char is smaller than prev char
                    return false;
                } else if (map.get(prevWord.charAt(pos)) < map.get(currWord.charAt(pos))) { // curr word char is greater than prev char then no need to check the rest of the characters
                    break;
                } else {
                    pos++; // at this pos both chars in curr and prev words are same, so continue to check for the next position
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        AlienDictionary_953 a = new AlienDictionary_953();
        System.out.println(a.isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz")); // true (second word first char is l and it comes later to h (first char of first word) as per the order.
        System.out.println(a.isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz")); //false //after first few characters, the next char of prev word is > curr word
        System.out.println(a.isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz")); //false  //second word is smaller and is prefix of first word.
        System.out.println(a.isAlienSorted(new String[]{"hello", "hello"}, "abcdefghijklmnopqrstuvwxyz")); //true //same words
        System.out.println(a.isAlienSorted(new String[]{"ubg", "kwh"}, "qcipyamwvdjtesbghlorufnkz")); //true
        System.out.println(a.isAlienSorted(new String[]{"apap", "app"}, "abcdefghijklmnopqrstuvwxyz")); //true  //after first few characters, the next char of prev word is < curr word
    }
}

