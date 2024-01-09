package AppleLeetcode;/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.




Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]


Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Eg: S = "23"  (2 - abc, 3 - def)
a - has 3 choices - ad ae af
b -  "            - bd be bf
c -  "            - cd ce cf

Time : choices ^ n = 3 ^2 = 9
In worst case, if there is 9 or 7 in the input (9 has 4 choices - wxyz)
Eg: 9999 then it would be 4^4
 */

public class LetterCombinationsOfPhoneNumber_17 {


    HashMap<Character, String> map;

    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();

        if(digits.length() == 0){
            return answer;
        }

        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        bkt(0, "", digits, answer);
        return answer;

    }


    public void bkt(int i, String currStr, String digits, List<String> answer){

        if(currStr.length() == digits.length()){ // or if(i == digits.length) (reached end of input)
            answer.add(currStr);
            return;
        }

        String letters = map.get(digits.charAt(i));
        for(char c : letters.toCharArray()){
            bkt(i+1, currStr + c, digits, answer);
        }

//        for(int idx=0; idx < letters.length(); idx++){
//            Character currChar = letters.charAt(idx);
//            bkt(i+1, currStr + Character.toString(currChar), digits, answer);
//        }
        return; //optional
    }

    public static void main(String[] args){
        LetterCombinationsOfPhoneNumber_17 l = new LetterCombinationsOfPhoneNumber_17();
        System.out.println(l.letterCombinations("23")); //ad, ae, af, bd, be, bf, cd, ce, cf
        System.out.println(l.letterCombinations("234")); //adg, adh, adi, aeg, aeh, aei, afg, afj, afi.. similarly starting with b and c = 27 combinations
        System.out.println(l.letterCombinations("999"));

    }
}
