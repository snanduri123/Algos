/*

 */

import java.util.ArrayList;
import java.util.Arrays;


public class Recur_Subsets_String {


    static ArrayList<String> answer;
    static ArrayList<String> generate_all_subsets(String s) {
        answer = new ArrayList<String>();
        findSubset( s,  0 ,  new StringBuilder());
        return answer;
    }

    static void findSubset(String s, int pos, StringBuilder currStr){

        answer.add(currStr.toString());

        for(int i = pos; i < s.length(); i++){
            currStr.append(s.charAt(i));
            findSubset( s,  i+1 ,  currStr);
            currStr.deleteCharAt(currStr.length()-1);
        }
    }

    public static void main(String[] args) {
        Recur_Subsets_String n = new Recur_Subsets_String();
        System.out.println(Arrays.deepToString(n.generate_all_subsets("xy").toArray()));
    }
}
