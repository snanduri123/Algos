/*
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

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generateParenthesis( 0,  0 ,  n,  "",  ans);
        return ans;
    }

    public void generateParenthesis(int open, int close , int total, String currentStr, List<String> ans) {
        if(open + close == total * 2) {
            ans.add(currentStr);
            System.out.println("currStr: " + currentStr);
            return;
        }
        if (open < total) {
            generateParenthesis(open + 1, close, total, currentStr + "(", ans);
            System.out.println("currStr: " + currentStr);
            System.out.println("open: " + open);
            System.out.println("close: " + close);
        }
        if (close < open) { //****close < OPEN
            generateParenthesis(open, close +1, total, currentStr + ")", ans);
            System.out.println("currStr: " + currentStr);
            System.out.println("open: " + open);
            System.out.println("close: " + close);
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
