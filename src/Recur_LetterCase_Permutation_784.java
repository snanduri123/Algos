/*
Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. Return the output in any order.



Example 1:

Input: s = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]
Example 2:

Input: s = "3z4"
Output: ["3z4","3Z4"]


Constraints:

1 <= s.length <= 12
s consists of lowercase English letters, uppercase English letters, and digits.
 */

import java.util.ArrayList;
import java.util.List;

public class Recur_LetterCase_Permutation_784 {
    List<String> answer;
    public List<String> letterCasePermutation(String s){
        answer = new ArrayList<>();
        //changeCase1( s,  0);
        changeCase( s,   new StringBuilder(), 0);
        return answer;
    }

    //Time: n * O(2^n).
    //Space: O(n^2)
    public void changeCase2(String str, int pos){
        if(pos == str.length()){  // or use (n == 0) while n is decremented (n-1) in every call.
            answer.add(str);
           return;
        }

        //if curr char is digit then I will not modify it and move on to solve sub problem that starts from next char.
        if(Character.isDigit(str.charAt(pos))){
            changeCase2( str,  pos + 1);
        }
        else if(Character.isLetter(str.charAt(pos))){  //if curr char is letter then I have two options
            //option a : I do not change it but change the rest of the sub problem
            changeCase2( str,  pos + 1);

            //option b : I convert it and then work on the rest of the sub problem
            char c = str.charAt(pos);

//            // title case converted to lower case
//            if (Character.isTitleCase(c)) {
//                c = Character.toLowerCase(c);
//            }
            // upper case converted to lower case
            if (Character.isUpperCase(c)) {
                c = Character.toLowerCase(c);
            }
            // lower case converted to upper case
            else if (Character.isLowerCase(c)) {
                c = Character.toUpperCase(c);
            }
            String s = str.substring(0, pos) + c + str.substring(pos+1, str.length());
            changeCase2( s,  pos + 1);
        }
    }

    //Time: n * O(2^n).
    //Space: O(n^2)  -> n strings created for all n (internal) nodes.
    public void changeCase1(String str, int pos){
        if(pos == str.length()){  // or use (n == 0) while n is decremented (n-1) in every call.
            answer.add(str);
            return;
        }

        //if curr char is digit then I will not modify it and move on to solve sub problem that starts from next char.
        if(Character.isDigit(str.charAt(pos))){
            changeCase1( str,  pos + 1);
        }
        else if(Character.isLetter(str.charAt(pos))){  //if curr char is letter then I have two options
            char c = str.charAt(pos);

            //option a : change it to lower case (if input is already lower case then this does not effect.
            c = Character.toLowerCase(c);
            str = str.substring(0, pos) + c + str.substring(pos+1);
            changeCase1( str,  pos + 1);


            //option b :  change it to upper case
            c = Character.toUpperCase(c);
            str = str.substring(0, pos) + c + str.substring(pos+1);
            changeCase1( str,  pos + 1);
        }

    }


    //Time: n * O(2^n).
    //Space: O(n)  -> n strings created at leaf nodes. (string buffer avoids new string creation at every node)
    public void changeCase(String inp, StringBuilder sb, int pos ) {
        if (inp.length() == sb.length()) {  // or use pos == inp.length()
            answer.add(sb.toString());
            return;
        }
        //if curr char is digit then I will not modify it and move on to solve sub problem that starts from next char.
        if (Character.isDigit(inp.charAt(pos))) {
            changeCase(inp, sb.append(inp.charAt(pos)), pos + 1);
        } else if (Character.isLetter(inp.charAt(pos))) {  //if curr char is letter then I have two options
            char c;
            //option a : change it to lower case (if input is already lower case then this does not effect.
            c = Character.toLowerCase(inp.charAt(pos));
            changeCase(inp,  sb.append(c), pos + 1);
            sb.deleteCharAt(pos); //delete the curr char, so that its counter case character can be added at same place.
            //option b :  change it to upper case
            c = Character.toUpperCase(inp.charAt(pos));
            inp = inp.substring(0, pos) + c + inp.substring(pos + 1);
            changeCase(inp,  sb.append(c), pos + 1);
        }
    }

    public static void main(String[] args){
        Recur_LetterCase_Permutation_784 l = new Recur_LetterCase_Permutation_784();
        System.out.println(l.letterCasePermutation("a1b2")); //[a1b2, a1B2, A1b2, A1B2]
        System.out.println(l.letterCasePermutation("aaaa")); //[aaaa, aaaA, aaAa, aaAA, aAaa, aAaA, aAAa, aAAA, Aaaa, AaaA, AaAa, AaAA, AAaa, AAaA, AAAa, AAAA]
        System.out.println(l.letterCasePermutation("BBBB"));  //[bbbb, bbbB, bbBb, bbBB, bBbb, bBbB, bBBb, bBBB, Bbbb, BbbB, BbBb, BbBB, BBbb, BBbB, BBBb, BBBB]
        System.out.println(l.letterCasePermutation("111111")); //[111111]
    }
}
