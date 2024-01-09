package AppleLeetcode;

public class LongestPalindromicSubstring {

    //Time: O(n^2)  - n (first for loop) *  n(while loop)
    //Space: O(1)
    /*
    Two forloops - one for odd and one for even.
    // recursive function with i, j  as arguments. For odd calls (i,j start with same index). For even j is i+1;
     */
    public String longestPalindrome(String s) {
        String maxString = "";
        for (int i = 0; i < s.length(); i++) {
            String palString = findLongestPalindrome(i, i, s);

            if (palString.length() > maxString.length()) {
                maxString = palString;
            }
        }

        for (int i = 0; i < s.length() - 1; i++) {
            String palString = findLongestPalindrome(i, i + 1, s);

            if (palString.length() > maxString.length()) {
                maxString = palString;
            }
        }
        return maxString;
    }

    public String findLongestPalindrome(int i, int j, String s) {

//        if (i < 0 || j >= s.length()) {
//            return "";
//        }
//
//        if (s.charAt(i) == s.charAt(j)) {
//            i--;
//            j++;
//            String palString = findLongestPalindrome(i, j, s);
//            return (palString.isEmpty() ? s.substring(i+1, j) : palString);
//        } else {
//            return s.substring(i+1, j);
//        }

        String longest = "";
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            longest = s.substring(i,j+1); //to include j for substring method (we add +1)
            i--;
            j++;
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring l1 = new LongestPalindromicSubstring();
        System.out.println(l1.longestPalindrome("babad")); //bab or aba

        LongestPalindromicSubstring l2 = new LongestPalindromicSubstring();
        System.out.println(l2.longestPalindrome("cbbd")); //bb

        LongestPalindromicSubstring l3 = new LongestPalindromicSubstring();
        System.out.println(l3.longestPalindrome("ab")); //a

        LongestPalindromicSubstring l4 = new LongestPalindromicSubstring();
        System.out.println(l4.longestPalindrome("adebb")); //bb

        LongestPalindromicSubstring l5 = new LongestPalindromicSubstring();
        System.out.println(l5.longestPalindrome("aaebd")); //aa
    }
}
