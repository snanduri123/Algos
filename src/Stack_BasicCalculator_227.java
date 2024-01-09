/*
Given a string s which represents an expression, evaluate this expression and return its value.

The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().



Example 1:

Input: s = "3+2*2"
Output: 7
Example 2:

Input: s = " 3/2 "
Output: 1
Example 3:

Input: s = " 3+5 / 2 "
Output: 5


Constraints:

1 <= s.length <= 3 * 105
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 231 - 1].
The answer is guaranteed to fit in a 32-bit integer.
 */

import java.util.Stack;

public class Stack_BasicCalculator_227 {

    public int calculate1(String s) {
        Stack<String> stack = new Stack<>();
        stack.push("+");
        s = s.replace(" ", "");
        for (int i = 0; i < s.length(); ) {
            if (s.charAt(i) == '*' || s.charAt(i) == '/') {

                char currSymbol = s.charAt(i);
                Integer num = 0;
                StringBuilder nextNum = new StringBuilder();
                i++; //to get the next number
                while (i < s.length() && Character.isDigit(s.charAt(i))) { //concate non single digit characters to string EG: 10 to "10"
                    nextNum = nextNum.append(s.charAt(i));
                    i++;
                }
                if (currSymbol == '*') {
                    num = Integer.valueOf(stack.peek()) * Integer.valueOf(nextNum.toString());
                } else if (currSymbol == '/') {
                    num =Integer.valueOf(stack.peek()) / Integer.valueOf(nextNum.toString());
                }
                stack.pop();
                stack.add(num.toString());
            } else {
                if(Character.isDigit(s.charAt(i))) {
                    StringBuilder num = new StringBuilder();
                    while (i < s.length() && Character.isDigit(s.charAt(i))) {
                        num = num.append(s.charAt(i));
                        i++;
                    }
                    stack.add(num.toString());
                }else{
                    stack.add(String.valueOf(s.charAt(i)));
                    i++;
                }
            }
        }
        int result = 0;
        while(!stack.isEmpty()) {
            int curr = Integer.valueOf(stack.pop());
            String sign = stack.pop();
            if (sign.equals("+")) {
                result += curr;
            } else {
                result -= curr;
            }
        }
        return result;
    }

    public int calculate(String s) {
        s = s.replace(" ", "");
        Stack<String> stack = new Stack<>();
        stack.push("+"); //when stack has only + and - operations we come from top by popping num and operation and add/sub to result.
                              //so when there is only 1 number in the stack with no operation then operation pop fails. So just add + at the bottom of stack now.
        for(int i =0; i< s.length(); ){
            StringBuilder digit = new StringBuilder();
            if(Character.isDigit(s.charAt(i))){
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    digit.append(s.charAt(i));
                    i++;
                }
                stack.push(digit.toString());
            }else if(s.charAt(i) == '+' || s.charAt(i) == '-'){
                stack.push(String.valueOf(s.charAt(i)));
                i++;
            }else{   // "* or / "
                char sign = s.charAt(i);
                //get the next number
                i++;
                StringBuilder nextNumber = new StringBuilder();
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    nextNumber.append(s.charAt(i));
                    i++;
                }
                int val = 0;
                if(sign == '*'){
                    val = Integer.valueOf(stack.pop()) * Integer.valueOf(nextNumber.toString());
                }else{
                    val = Integer.valueOf(stack.pop()) / Integer.valueOf(nextNumber.toString());
                }
                stack.push(String.valueOf(val));
            }
        }
        //Get top number and sign below it to check if it is +ve or -ve number and add or subtract from the result.
        int result = 0;
        while(!stack.isEmpty()) {
            int curr = Integer.valueOf(stack.pop());
            String sign = stack.pop();
            if (sign.equals("+")) {
                result += curr;
            } else {
                result -= curr;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Stack_BasicCalculator_227 R = new Stack_BasicCalculator_227();
        System.out.println(R.calculate("1+1+1")); //3
        System.out.println(R.calculate("42")); //42   //double digit
        System.out.println(R.calculate("3+2*2")); //7
        System.out.println(R.calculate("3/2")); //1
        System.out.println(R.calculate("3+5/2")); //5
        System.out.println(R.calculate("3+5 / 2")); //5   //spaces
        System.out.println(R.calculate("1-1+1")); //1
        System.out.println(R.calculate("1*2-3/4+5*6-7*8+9/10")); //-24
    }
}
