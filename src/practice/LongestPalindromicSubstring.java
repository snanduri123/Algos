package practice;

public class LongestPalindromicSubstring {

    //Time: O(n^2)  - n (first for loop) *  n(while loop)
    //Space: O(1)
    /*
    Two forloops - one for odd and one for even.
    // recursive function with i, j  as arguments. For odd calls (i,j start with same index). For even j is i+1;
     */
    String ans = "";
    public String longestPalindrome(String s) {
        for(int i = 0; i < s.length();i++){
           findLongestPalindrome( i,  i,  s); //one char as center
           findLongestPalindrome( i,  i+1,  s); //two characters as center
        }
        return ans;
    }
    public void findLongestPalindrome(int i, int j, String s) {
        if(i <0 || j > s.length()-1){
            return;
        }
        if(s.charAt(i) == s.charAt(j)){
            int len = j-i+1;
            if(len > ans.length()){
                ans = s.substring(i, j+1);
            }
            findLongestPalindrome( i-1,  j+1,  s);
        }
    }

    public void findLongestPalindrome1(int i, int j, String s) {
        while (i >= 0 && j <= s.length() - 1) {
            if(s.charAt(i) == s.charAt(j)){
                int len = j-i+1;
                if(len > ans.length()){
                    ans = s.substring(i, j+1);
                }
            }else{
                break;
            }
            i--;
            j++;
        }
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
