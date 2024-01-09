/*
Given a string s, return the length of the longest substring between two equal characters, excluding the two characters. If there is no such substring return -1.

A substring is a contiguous sequence of characters within a string.



Example 1:

Input: s = "aa"
Output: 0
Explanation: The optimal substring here is an empty substring between the two 'a's.
Example 2:

Input: s = "abca"
Output: 2
Explanation: The optimal substring here is "bc".
Example 3:

Input: s = "cbzxy"
Output: -1
Explanation: There are no characters that appear twice in s.


Constraints:

1 <= s.length <= 300
s contains only lowercase English letters.
 */

import java.util.Arrays;
public class LargestSubstringBetweenTwoEqualCharacters_1624 {

    //Time: O(n)
//Space: O(26) = O(k)

    public int maxLengthBetweenEqualCharacters(String s) {
        int[] firstOccurance = new int[26];

        int maxLength = -1;

        for(int i =0 ; i< s.length(); i++){

            if(firstOccurance[s.charAt(i)-'a'] > 0) { //if char is already present then check the length;
                maxLength = Math.max(maxLength, i - firstOccurance[s.charAt(i)-'a']);
            }
            else{ //store first occurance of the character, but store by adding one so that when we check the length after finding the second occurace as above.
                firstOccurance[s.charAt(i)-'a'] = i + 1; //Eg: abcda --> a at 1,4 indexes. substring length = 4 -1 = 3.
            }
        }

        return maxLength;
    }

    //Time: O(n) + O(26)orO(n) = O(n)
    //Space: O(26) = O(k)

    public int maxLengthBetweenEqualCharacters2(String s) {
        int[][] positions = new int[26][2];

        for(int[] position : positions) {
            Arrays.fill(position, -1); // so that for char 'a' if it is at index=0 in the input then we can save that index 0 in the positions array.
        }

        int idx = 0;
        for(char c : s.toCharArray()){
            if(positions[c - 'a'][0] == -1){
                positions[c - 'a'][0] = idx;
            }
            else{
                positions[c - 'a'][1] = idx;
            }
            idx++;
        }

        int maxlength = -1;
        int[] pos = new int[2];

        for(int i=0; i<positions.length; i++){
            //if a char occurs at least twice i.e., pos[1] is >-1 and if the distance between two occurances is big
            if(positions[i][1] > -1 && (positions[i][1] - positions[i][0] > maxlength) ){
                maxlength = positions[i][1] - positions[i][0];
                pos[0] = positions[i][0];
                pos[1] = positions[i][1];
            }
        }

        return maxlength == -1 ? maxlength :  maxlength -1;
//        if(maxlength == -1) //if there are no two equal characters in input and hence no substring
//            return -1;
//        else
//            return s.substring(pos[0]+1, pos[1]).length();
    }

    public static void main(String[] args){
        LargestSubstringBetweenTwoEqualCharacters_1624 l = new LargestSubstringBetweenTwoEqualCharacters_1624();
        System.out.println(l.maxLengthBetweenEqualCharacters("aa")); //0  ""
        System.out.println(l.maxLengthBetweenEqualCharacters("abca")); //2 "bc"
        System.out.println(l.maxLengthBetweenEqualCharacters("cbzxy")); //-1

    }

}
