import java.util.Stack;

public class Decode_String_Iteration_394 {

    public static void main(String[] args) {
        Decode_String_Iteration_394 d = new Decode_String_Iteration_394();
       // System.out.println(d.decodeString("3[a]2[bc]")); //"aaabcbc"
        System.out.println(d.decodeString("3[a2[c]]")); //  "accaccacc".
        System.out.println(d.decodeString("2[abc]3[cd]ef")); //"abcabccdcdcdef"
    }

    public String decodeString(String s) {

        String newString = "";
        Stack<Character> stack = new Stack<>();
        String num = "";
        for (int i = 0; i < s.length(); i++) {

            //find number
            int charVal = s.charAt(i);
            if ((charVal <65 || charVal > 91) && (charVal <97 || charVal > 123)) {
                num = num + Character.toString(s.charAt(i));
            }

            if (s.charAt(i) == '[') { //if not number then put characters between square brackets in stack
                i++; //skip left square bracket
                while (s.charAt(i) != ']') {
                    stack.push(s.charAt(i));
                    i++;
                }

                //construct string with the characters (in between set of [] brackets of original string) that are stacked in stack.
                String codeString = "";
                while (!stack.empty()) {
                    Character ch = stack.pop(); //pop removes the object
                    codeString = ch.toString() + codeString;
                }
                //repeat the codeString as many times as the num
                for (int j = 0; j < Integer.parseInt(num); j++) {
                    newString = newString + codeString;
                }
                num = "";
            }


        }
        return newString;
    }
}
