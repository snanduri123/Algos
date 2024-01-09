import java.util.ArrayList;

public class String_Reorganize_767 {

    public String reorganizeString(String s) {
        char[] ans = new char[s.length()];
        int[] charCounts = new int[26];
        int maxCount = 0;
        char maxChar = ' ';
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            charCounts[c -  'a']++;
            if(maxCount > charCounts[c-'a']){
                maxChar = c;
            }
        }

        if(maxCount > s.length()/2)
            return "";

        // Place the most frequent letter at alternate indeces starting from 0
        int idx = 0;
        while(charCounts[maxChar - 'a'] > 0){
            ans[idx] = maxChar;
            idx = idx + 2;
            charCounts[maxChar - 'a']--;
        }

        //Place rest of the characters starting from index 1.
        idx = 1;
        for(int i = 0; i < charCounts.length; i++){
            while(charCounts[i] > 0){
                if(idx >= s.length()){
                    idx = 1;
                }
                ans[idx] = (char)('a' + i);
                charCounts[i]--;
                idx = idx + 2;
            }
        }
        return String.valueOf(ans);
    }

    public static void main(String[] args){
        String_Reorganize_767 s = new String_Reorganize_767();
        System.out.println(s.reorganizeString("aab")); //aba
        System.out.println(s.reorganizeString("abaa")); //null
        System.out.println(s.reorganizeString("vvvlo")); //vlvov
    }
}
