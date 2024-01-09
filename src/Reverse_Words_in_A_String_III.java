/*Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

        Example 1:
        Input: "Let's take LeetCode contest"
        Output: "s'teL ekat edoCteeL tsetnoc"
        Note: In the string, each word is separated by single space and there will not be any extra space in the string.
        */

public class Reverse_Words_in_A_String_III {

    public static void main(String args[]) {
        Reverse_Words_in_A_String_III r = new Reverse_Words_in_A_String_III();
        System.out.println(r.reverseWords("Let's take LeetCode contest")); //"s'teL ekat edoCteeL tsetnoc"
        System.out.println(r.reverseString_StringBuilder("Let's take LeetCode contest")); //"s'teL ekat edoCteeL tsetnoc"
        System.out.println(r.reverseString_StringBuilder2("Let's take LeetCode contest")); //"s'teL ekat edoCteeL tsetnoc"
    }

    public String reverseWords(String s) {

        String newString = "";
        String[] strings = s.split(" ");

        for (int i = 0; i < strings.length; i++) {
            if (newString.length() > 0) {
                newString = newString + " "; //use + or concat to concate two strings
            }
            newString = newString.concat(reverseWord(strings[i]));

        }
        return newString;
    }

    public String reverseWord(String s) {
        String newStr = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            newStr = newStr + s.charAt(i);
        }
        return newStr;
    }

    //using string builder's reverse function
    public String reverseString_StringBuilder(String s) {

        StringBuilder stringBuilder = new StringBuilder();

        for (String str : s.split(" ")) {

            if(stringBuilder.length() > 0) {
                stringBuilder.append(" ");
            }
            StringBuilder part = new StringBuilder(str).reverse();
            stringBuilder.append(part );

        }

        return stringBuilder.toString();
    }



    //using string builder's append function
    public String reverseString_StringBuilder2(String s) {

        StringBuilder answer = new StringBuilder();

        for (String word : s.split(" ")) {
            for (int j = word.length() -1; j>=0;){
                answer.append(word.charAt(j));
                j--;
            }
            answer.append(" ");
        }
        answer.deleteCharAt(s.length()); //remove last appended extra space.
        return answer.toString();
    }


    //using char array //fastest.
    public String reverseString_charArr_Fastest(String s) {

        char[] a = s.toCharArray();
        int i=0, j=0, n=s.length();
        while (j<n){
            while (j<n && a[j] != ' ') j++; //travel uptil the first space
            reverse(a, i, j-1); //reverse the word before the space
            j ++;
            i = j;
        }
        return new String(a);
    }

    public void reverse(char[] a, int i, int j){
        while (i<j){
            char t = a[j];
            a[j] = a[i];
            a[i] = t;
            i++;
            j--;
        }
    }
}
