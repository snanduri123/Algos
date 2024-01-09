/*Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
*/

// Two ways to do  - recursion and iteration . Recursion would throw stack overflow for long strings. But iteration does not. Learn two methods.

//Time - O(n). Space - constant.
class Valid_Palindrome_125 {
    public boolean isPalindrome(String s) {
        int i=0, j = s.length() -1;
        while( i<=j ){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            else if(!Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            else {
                if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
    public boolean isPalindrome_Iteration(String s) {  // no stackoverflow
        boolean b = true;
        //two pointers : "start" --> starts from LEFT END of the string and "end" ---> starts from RIGHT END of the string.
        for (int start = 0, end = s.length() - 1; start <= end && b; ) {
            //if both start index character and end index character are alphanumeric
            if ((((s.charAt(start) >= 'A' && s.charAt(start) <= 'Z') || (s.charAt(start) >= 'a' && s.charAt(start) <= 'z')) ||
                    (s.charAt(start) >= '0' && s.charAt(start) <= '9'))
                    &&
                    (((s.charAt(end) >= 'A' && s.charAt(end) <= 'Z') || (s.charAt(end) >= 'a' && s.charAt(end) <= 'z')) ||
                            (s.charAt(end) >= '0' && s.charAt(end) <= '9'))) {

               // System.out.println("start " + start + " --> " + s.charAt(start) + " " + "end " + end + "----> " + s.charAt(end));

                // if both start index character and end index character are not same then return false;
                if (!Character.toString(s.charAt(start)).equalsIgnoreCase(Character.toString(s.charAt(end)))) {
                    b = false;
                } else { //increment left pointer and decrement right pointer
                    start = start + 1;
                    end = end - 1;
                }

            }  // if end index is not alphanumeric then skip it
            else if ((s.charAt(start) >= 'A' && s.charAt(start) <= 'Z') || (s.charAt(start) >= 'a' && s.charAt(start) <= 'z') ||
                    (s.charAt(start) >= '0' && s.charAt(start) <= '9')) {
                end = end - 1;
            } // if start index is not alphanumeric then skip it
            else if ((s.charAt(end) >= 'A' && s.charAt(end) <= 'Z') || (s.charAt(end) >= 'a' && s.charAt(end) <= 'z') ||
                    (s.charAt(end) >= '0' && s.charAt(end) <= '9')) {
                start = start + 1;
            } // if both start and end indices are not alphanumeric then skip both of them.
            else {
                start = start + 1;
                end = end - 1;
            }
        }
        return b;
    }

    public static void main(String[] args) {


        Valid_Palindrome_125 v = new Valid_Palindrome_125();

        String s = "A man, a plan, a canal: Panama"; //true

        String s2 = "race a car"; //false

        String s3 = " "; //true

        String s4 = "0P"; //false

        String s5 = "8V8K;G;K;V;"; //false

        String s6 = ".;"; //true

        System.out.println(v.isPalindrome(s));
        System.out.println(v.isPalindrome(s2));
        System.out.println(v.isPalindrome(s3));
        System.out.println(v.isPalindrome(s4));
        System.out.println(v.isPalindrome(s5));
        System.out.println(v.isPalindrome(s6));
    }
}