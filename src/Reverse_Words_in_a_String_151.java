/*
Given an input string, reverse the string word by word.

Example:

Input: "the sky is blue",
Output: "blue is sky the".
Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
Follow up: For C programmers, try to solve it in-place in O(1) space.

 */

public class Reverse_Words_in_a_String_151 {

    public static void main(String[] args) {
        Reverse_Words_in_a_String_151 r = new Reverse_Words_in_a_String_151();
        System.out.println(r.reverseWords("the sky is blue")); //"blue is sky the"
        System.out.println(r.reverseWords(" 1")); //1
        System.out.println(r.reverseWords("   a   b ")); //b a
    }


    //Time: O(n)
    //Space : O(n)
    public static String reverseWords(String s){
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        for(int j= words.length-1; j >=0; j--){
            if(words[j] != "") { //IMP:after splitting the string, leading spaces generate empty chars. In case of empty character, do not append
                sb.append(words[j]);
                sb.append(" ");
            }else{
                System.out.println("spaces converted to empty char");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    //Time - O(n) , space - O(n) but elegant solution without using string functions, string builder
    public String reverseWords1(String s) {
        if (s == null) return null;

        char[] a = s.toCharArray();
        int n = a.length;

        // step 1. reverse the whole string -- O(n)
        reverse(a, 0, n - 1);
        // step 2. reverse each word -- O(n)
        reverseWords(a, n);
        // step 3. clean up spaces -- O(n)
        return cleanSpaces(a, n);
    }

    void reverseWords(char[] a, int n) {
        int i = 0, j = 0;

        while (i < n) {
            while (i < j || i < n && a[i] == ' ') i++; // skip spaces
            while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
            reverse(a, i, j - 1);                      // reverse the word
        }
    }

    // trim leading, trailing and multiple spaces
    String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && a[j] == ' ') j++;             // skip spaces
            while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
            while (j < n && a[j] == ' ') j++;             // skip spaces
            if (j < n) a[i++] = ' ';                      // keep only one space
        }

        return new String(a).substring(0, i);
    }

    // reverse a[] from a[i] to a[j]
    private void reverse(char[] a, int i, int j) {
        while (i < j) {
            char t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
    }

    //Time = O(n), space = n
    public String reverseWords_UsingStringFunctions(String s) {

        s = s.trim(); //remove leading or trailer spaces
        while (s.contains("  ")) { // reduce multiple spaces to single space
            s = s.replace("  ", " ");
        }
        String[] strings = s.split(" ");
        String newString = "";

        for (int i = strings.length - 1; i >= 0; i--) {
            if (newString.length() > 0) {
                newString = newString + " ";
            }

            newString = newString + strings[i];
        }

        return newString;
    }
}
