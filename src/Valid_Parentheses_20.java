import java.util.ArrayList;
import java.util.Stack;

public class Valid_Parentheses_20 {

    public static void main(String[] args){
        Valid_Parentheses_20 v = new Valid_Parentheses_20();
//        System.out.println(v.isValid("{")); //false
        System.out.println(v.isValid("}")); //false
        System.out.println(v.isValid("()")); //true
        System.out.println(v.isValid("()[]{}"));//true
        System.out.println(v.isValid("(]"));//false
        System.out.println(v.isValid("([)]")); //false
        System.out.println(v.isValid("{[]}")); //true
    }

    public boolean isValid1(String s) {

        Stack<Character> charStack = new Stack<Character>();
        ArrayList<Character> a1 = new ArrayList<Character>();
        ArrayList<Character> a2 = new ArrayList<Character>();

        a1.add('{');
        a1.add('[');
        a1.add('(');

        a2.add('}');
        a2.add(']');
        a2.add(')');

        for (int i = 0; i < s.length(); i++) {
            if (a1.contains(s.charAt(i))) {
                charStack.push(s.charAt(i));
            } else {
                int idx2 = a2.indexOf(s.charAt(i));
                if(charStack.isEmpty() || (a1.indexOf(charStack.pop()) != idx2)) {
                    return false;
                }
            }
        }
        return (charStack.isEmpty()) ? true : false;
    }


    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();

        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(')');
            }
            else if(s.charAt(i) == '{'){
                stack.push('}');
            }
            else if(s.charAt(i) == '['){
                stack.push(']');
            }
            else if(stack.empty() || stack.pop() != s.charAt(i)){
                return false;
            }
        }
        return (stack.isEmpty());
    }
}
