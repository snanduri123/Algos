import java.util.HashMap;

/*
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.



Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true


Constraints:

1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.
 */
public class RansomNote {

    //Time complexity: O(m)(ransomnote) + O(n)(magazine) + O(n)(magazinemap) -> O(n)
    //Space complexity: O(n)
    public boolean canConstruct(String ransomNote, String magazine) {

        if((magazine==null) || (ransomNote.length() > magazine.length()))
            return false;
        HashMap<Character, Integer> map = new HashMap<Character,Integer>();
        for(char ch: magazine.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }

        for(char ch: ransomNote.toCharArray()){
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
            }
            else
                return false;
        }

        for(Integer val : map.values()){
            if(val < 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        RansomNote t = new RansomNote();
        System.out.println(t.canConstruct("a", "b")); //false
        System.out.println(t.canConstruct("aa", "bb")); //false
        System.out.println(t.canConstruct("aab", "aabbc")); //true
    }
}
