import java.util.Arrays;

public class ReverseAString_344 {

    public static void main(String[] args){
        reverseString(new char[] {'h','e','l','l','o'});
        System.out.println(reverseString_String("hellop"));
        System.out.println(reverseString_StringBuffer("hellop"));
        System.out.println(reverseString_Recursion("hellop"));
    }


    //****Best Option****
    public static void reverseString(char[] s) {
        char temp; //
        for(int i=0, j=s.length-1; i<j; i++,j--){
            temp = s[j];
            s[j] = s[i];
            s[i] = temp;
        }
        System.out.println(Arrays.toString(s));
    }

    //This method is correct but this fails if the string is very big.
    public static String reverseString_String(String s) {

        if(s==null)
            return null;

        char[] charArr = s.toCharArray();
        String newString = "";
        for(int i=charArr.length-1; i >= 0; i--){
           newString =  newString + Character.toString(charArr[i]);
        }
        return newString;
    }

    //Using StringBuffer and its append method.
    public static String reverseString_StringBuffer(String s) {
        int sSize = s.length();
        StringBuffer sBuffer = new StringBuffer(sSize);
        for (int i=sSize-1; i>=0; i--) {
            sBuffer.append(s.charAt(i));
        }
        return sBuffer.toString();
    }

    //Using recursion. This also fails for long string because of too much memory.
    public static String reverseString_Recursion(String s) {

        if(s==null || s.length() == 0) // string length will be 0 when string is empty
            return "";

        String newStr = String.valueOf(s.charAt(s.length() - 1));
        newStr = newStr + reverseString_Recursion(s.substring(0,s.length()-1));
        return newStr;

    }

    //using string builder's reverse function
    public static void reverseString_StringBuilder(String s)
    {

        StringBuilder input1 = new StringBuilder(s);

        // reverse StringBuilder input1
        input1 = input1.reverse();

        // print reversed String
        System.out.println(input1);
    }


}
