/*Given two strings s and t , write a function to determine if t is an anagram of s.

        Example 1:

        Input: s = "anagram", t = "nagaram"
        Output: true
        Example 2:

        Input: s = "rat", t = "car"
        Output: false
        Note:
        You may assume the string contains only lowercase alphabets.

        Follow up:
        What if the inputs contain unicode characters? How would you adapt your solution to such case
*/

public class Valid_Anagram_242 {

    public static void main(String[] args){
        System.out.println(isAnagram( "anagram",  "nagaram"));
    }
    public static boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        char[] chB = new char[26];  // '\u0000' is the default value for a character. Its decimal equivalent is 0.System.out.println('\u0000'); prints a little square, meaning that it's not a printable character - as expected.

        for (int i = 0 ; i < s.length() ; i ++) {

            System.out.println("value0 is " + s.charAt(i));
            System.out.println("value1 is " + (s.charAt(i) - 'a'));
            System.out.println("value2 is " + chB[s.charAt(i) - 'a']);
            System.out.println("value2 is " + chB[t.charAt(i) - 'a']);
            chB[s.charAt(i) - 'a']++;
            chB[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < chB.length ; i++){
            if (chB[i] != 0) return false;
        }
        return true;

    }

    public static boolean isAnagram2(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        int[] a = new int[26];

        for (int i = 0 ; i < s.length() ; i ++) {
            a[s.charAt(i) - 'a']++;
            a[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < a.length ; i++){
            if (a[i] != 0) return false;
        }
        return true;

    }
}
