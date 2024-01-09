import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
In a string s of lowercase letters, these letters form consecutive groups of the same character.

For example, a string like s = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z", and "yy".

A group is identified by an interval [start, end], where start and end denote the start and end indices (inclusive) of the group. In the above example, "xxxx" has the interval [3,6].

A group is considered large if it has 3 or more characters.

Return the intervals of every large group sorted in increasing order by start index.



Example 1:

Input: s = "abbxxxxzzy"
Output: [[3,6]]
Explanation: "xxxx" is the only large group with start index 3 and end index 6.
Example 2:

Input: s = "abc"
Output: []
Explanation: We have groups "a", "b", and "c", none of which are large groups.
Example 3:

Input: s = "abcdddeeeeaabbbcd"
Output: [[3,5],[6,9],[12,14]]
Explanation: The large groups are "ddd", "eeee", and "bbb".


Constraints:

1 <= s.length <= 1000
s contains lowercase English letters only.
 */
public class PositionsOfLargeGroups_830 {

    //Time: O(n)
    //Space: O(1)
    public List<List<Integer>> largeGroupPositions(String s) {

        List<List<Integer>> answer = new ArrayList<>();
        char prevChar = '\u0000';
        int startIdx = -1;
        int cnt = 0;

        for(int i=0; i< s.length(); i++){
            if(s.charAt(i) !=prevChar){
                if(cnt >=3){
                    answer.add(Arrays.asList(startIdx,i-1));
                }
                cnt = 1;
                startIdx = i;
                prevChar = s.charAt(i);
            }
            else{
                cnt++;
            }
        }
        // if there is group at the right end then the computation is done here because it would be skipped in the above for loop because of i < s.length condition.
        if(cnt >=3){
            answer.add(Arrays.asList(startIdx,s.length()-1));
        }
        return answer;
    }

    public static void main (String[] args){
        PositionsOfLargeGroups_830 p = new PositionsOfLargeGroups_830();
        System.out.println(p.largeGroupPositions("abcdddeeeeaabbbcd")); //[[3,5],[6,9],[12,14]]
    }
}
