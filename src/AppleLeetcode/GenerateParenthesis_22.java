package AppleLeetcode;/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]


Constraints:

1 <= n <= 8
 */

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis_22 { //medium

    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        generateParenthesis( 0 ,  0,  n,  "");
        return ans;
    }

    public void generateParenthesis(int open, int close, int n, String currString) {

        if(open == n && close == n){
            ans.add(currString);
        }

        if(open < n){
            generateParenthesis( open + 1,  close,  n,  currString + "(");
        }

        if(close < open){
            generateParenthesis( open ,  close + 1,  n,  currString + ")");
        }
    }

    public static void main(String[] args){
        GenerateParenthesis_22 g = new GenerateParenthesis_22();

        List<String> res = g.generateParenthesis(3);
        /*
        ((()))
        (()())  --> for last taken open bracket, do another option i.e, take close ) bracket and start recursion from there
        (())()
        ()(())
        ()()()
         */
        for (String s : res) {
            System.out.println(s);
        }
    }
}
