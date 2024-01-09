package AppleLeetcode;

/* Write a method to replace all spaces in a string with ‘%20’
// input char[] str -> “a b c”; output -> “a%20b%20c”
 */
public class StringURLify {
    public String convertString(String s) {
        char[] ch;   //output arr
        int chLen = 0;
        int spacesLen = 0;
        String newVal = "%20";
        char[] newValA = newVal.toCharArray();
        int i = 0; //o/p idx
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                spacesLen++;
            } else {
                chLen++;
            }
        }
        ch = new char[chLen + spacesLen * 3];
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                ch[i++] = c;
            } else {
                for (char a : newValA) {
                    ch[i++] = a;
                }
            }
        }
        return String.valueOf(ch);
    }
}
