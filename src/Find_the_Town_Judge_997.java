/*
In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi. If a trust relationship does not exist in trust array, then such a trust relationship does not exist.

Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.



Example 1:

Input: n = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: n = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:

Input: n = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1


Constraints:

1 <= n <= 1000
0 <= trust.length <= 104
trust[i].length == 2
All the pairs of trust are unique.
ai != bi
1 <= ai, bi <= n
 */

import java.util.HashMap;
import java.util.HashSet;

public class Find_the_Town_Judge_997 {

    //Time: O(n)
    //Space: O(n)
    //Ask interviewer if there would be only one judge. If there are >1 judges then it breaks the rule that judge can't trust anybody.
    public int findJudge(int n, int[][] trust) {
        if (trust.length < n - 1) { //if there are 3 people then 1 is judge, so for remaining 2 people the input should have 2 relationships and not less than that.
            return -1;
        }

        int[] trustScores = new int[n + 1]; // because there is no "0" person and hence 0th index is not used. So for two people we need size 3 so that index 1 and 2 for those two people and index 0 is unused. So

        for (int[] relation : trust) {
            trustScores[relation[0]]--;
            trustScores[relation[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (trustScores[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Find_the_Town_Judge_997 F = new Find_the_Town_Judge_997();
        System.out.println(F.findJudge(2,new int[][]{{1,2}})); //2
        System.out.println(F.findJudge(2,new int[][]{{1,3},{2,3}})); //3
        System.out.println(F.findJudge(3,new int[][]{{1,3},{2,3},{3,1}})); //-1
        System.out.println(F.findJudge(1,new int[][]{})); // 1 (1 present but no relationship means he is the judge)
    }

}
