import java.util.HashMap;
import java.util.Map;

/*Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.



Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
Example 2:

Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".
Example 3:

Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".


Constraints:
1 <= s.length, t.length <= 200
s and t only contain lowercase letters and '#' characters.

 */

public class BackSpace_String_Compare_844 {

    //O(s) + O(t)
    //Space: O(s) + O(t)
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i< s.length(); i++){
            if( t.charAt(i) == '#'){
                if(sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
            else{
                sb.append(s.charAt(i));
            }
        }

        StringBuilder tb = new StringBuilder();

        for(int i =0 ; i< t.length(); i++){
            if( t.charAt(i) == '#'){
                if(tb.length() > 0) {
                    tb.deleteCharAt(tb.length() - 1);
                }
            }
            else{
                tb.append(t.charAt(i));
            }
        }
        return sb.toString().equals(tb.toString());
    }

    public static void main(String[] args) {
        BackSpace_String_Compare_844 t = new BackSpace_String_Compare_844();
        System.out.println(t.backspaceCompare("y#fo##f", "y#f#o##f")); //true
        System.out.println(t.backspaceCompare("a#c", "y#f#o##f")); //true
    }
}
