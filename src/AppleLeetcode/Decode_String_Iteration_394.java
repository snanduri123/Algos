package AppleLeetcode;

import java.util.Stack;

public class Decode_String_Iteration_394 {

    public static void main(String[] args) {
        Decode_String_Iteration_394 d = new Decode_String_Iteration_394();
         System.out.println(d.decodeString("3[a]2[bc]")); //"aaabcbc"
        System.out.println(d.decodeString("3[a2[c]]")); //  "accaccacc".
        System.out.println(d.decodeString("2[abc]3[cd]ef")); //"abcabccdcdcdef"
    }

    public String decodeString(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != ']') { //push every char other than closing bracket into stack
                stack.push(s.charAt(i));
            } else { //if you find a closing ]

                //step 1:  retrieve the string it encapsulates
                StringBuilder encapStr = new StringBuilder();
                while (!stack.isEmpty() && Character.isLetter(stack.peek()) ) {
                    encapStr.insert(0, stack.pop());
                }
                //step 2:  IGNORE '[' to get number (now you got encapsulated string and reached '[' in stack)
                stack.pop();

                //step 3:  construct the number
                StringBuilder number = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    number.insert(0, stack.pop());
                }
                int num = Integer.valueOf(number.toString());

                //step 4: expand the string by number times
                StringBuilder expandString = new StringBuilder();
                for (int count = 0; count < num; count++) {
                    expandString.append(encapStr);
                }

                //step5: Now add all the characters of expanded string back into stack.
                for (char c : expandString.toString().toCharArray()) {
                    stack.add(c);
                }
            }

        }

        //step6: convert stack char to string
        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) {
            answer.insert(0, stack.pop());
        }
        return answer.toString();
    }

}
