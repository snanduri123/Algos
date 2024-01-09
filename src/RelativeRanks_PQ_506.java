import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/*
You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition. All the scores are guaranteed to be unique.

The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:

The 1st place athlete's rank is "Gold Medal".
The 2nd place athlete's rank is "Silver Medal".
The 3rd place athlete's rank is "Bronze Medal".
For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").
Return an array answer of size n where answer[i] is the rank of the ith athlete.



Example 1:

Input: score = [5,4,3,2,1]
Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].
Example 2:

Input: score = [10,3,8,9,4]
Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
Explanation: The placements are [1st, 5th, 3rd, 2nd, 4th].



Constraints:

n == score.length
1 <= n <= 104
0 <= score[i] <= 106
All the values in score are unique.
 */
public class RelativeRanks_PQ_506 {

    //Time complexity : O(n)
    //Space complexity: O(n) pq + O(k) hashmap
    public String[] findRelativeRanks(int[] score) {

        String[] placements = new String[score.length];
        HashMap<Integer, String> map = new HashMap<Integer, String>() {{
            put(1, "Gold Medal");
            put(2, "Silver Medal");
            put(3, "Bronze Medal");
        }};

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        /*or use Arrays instead of pq.
        int[][] num2d = new int[nums.length][2];
        Arrays.sort(num2d, (a, b) -> b[1] - a[1]);
         */

        for (int i = 0; i < score.length; i++) {
            //int[] idxScore = new int[2][];
            int[] idxScore = new int[]{i, score[i]};
            pq.add(idxScore);
        }

        int count = 1;
        while (!pq.isEmpty()) {
            int[] elem = pq.poll();
            if (count <= 3) {
                placements[elem[0]] = map.get(count);
            } else {
                placements[elem[0]] = String.valueOf(count);
            }
            count++;
        }

        return placements;
    }

    public static void main(String[] args){
        RelativeRanks_PQ_506 R = new RelativeRanks_PQ_506();
        System.out.println(Arrays.toString(R.findRelativeRanks(new int[]{5,4,3,2,1}))); //["Gold Medal","Silver Medal","Bronze Medal","4","5"]
        System.out.println(Arrays.toString(R.findRelativeRanks(new int[]{10,3,8,9,4}))); // ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
    }
}
