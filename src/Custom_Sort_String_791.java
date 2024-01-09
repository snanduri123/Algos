/*
S and T are strings composed of lowercase letters. In S, no letter occurs more than once.

S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.

Return any permutation of T (as a string) that satisfies this property.

Example :
Input:
S = "cba"
T = "abcd"
Output: "cbad"
Explanation:
"a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a".
Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.
*/

// Time - O(s + t )
//Space - O(s)
import java.util.HashMap;
import java.util.Map;

public class Custom_Sort_String_791 {

    public static void main(String[] args){
        Custom_Sort_String_791 c = new Custom_Sort_String_791();
        System.out.println(c.customSortString("cba", "abcd")); // cbad
    }

    public String customSortString(String S, String T) {
       int[] arr = new int[26];
       char[] result = new char[T.length()];

        for(int i =0; i< T.length(); i++) {
            arr[T.charAt(i) - 'a'] = arr[T.charAt(i) - 'a'] + 1; // converting char to integer
        }

        int idx = 0;
        for(int i =0 ; i<S.length(); i++) {
          if(arr[S.charAt(i) - 'a'] > 0) {
              while(arr[S.charAt(i) - 'a'] > 0) {
                  result[idx] = S.charAt(i);
                  idx++;
                  arr[S.charAt(i) - 'a'] = arr[S.charAt(i) - 'a'] - 1;
              }

          }

        }

        for(int i =0 ; i<arr.length; i++) {
                while(arr[i] > 0) {
                    result[idx] = (char)(i + 'a');  // converting integer to char
                    idx++;
                    arr[i] = arr[i] - 1;
                }
        }


        return String.valueOf(result);
    }

    public String customSortString_HashMap(String S, String T) {
        HashMap<Character, Integer> map = new HashMap<>();
        String customString = "";
        for(int i =0; i< T.length(); i++) {
            if(map.containsKey(T.charAt(i)))
            {
                map.put(T.charAt(i), map.get(T.charAt(i)) + 1);
            }
            else{
                map.put(T.charAt(i), 1);
            }
        }
       for(int i =0 ; i<S.length(); i++) {
           if(map.containsKey(S.charAt(i))){
               for(int j = 0; j< map.get(S.charAt(i)); j++){
                   customString = customString + Character.toString(S.charAt(i));
               }
           }
           map.remove(S.charAt(i));
       }

       for(Map.Entry<Character, Integer> entry : map.entrySet()){
           for(int i=0; i< entry.getValue(); i++){
               customString = customString + Character.toString(entry.getKey());
           }
       }

       return customString;
    }
}
