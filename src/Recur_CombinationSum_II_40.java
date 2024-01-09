/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.



Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output:
[
[1,2,2],
[5]
]


Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recur_CombinationSum_II_40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<List<Integer>> answer = new ArrayList<>();
        getCombinationSum2(0, candidates, target, new ArrayList<>(), 0, answer);
        return answer;
    }

    public void getCombinationSum2(int idx, int[] candidates, int target, List<Integer> combination, int prevSum, List<List<Integer>> answer) {


        if (prevSum == target) {  //previoussum
            answer.add(new ArrayList<>(combination));
            return;
        }

//        if (idx >= candidates.length || prevsum > target) {
//            return;
//        }

        for (int i = idx; i < candidates.length; i++) {
            if (prevSum + candidates[i] <= target) { // curr validation/checking
                combination.add(candidates[i]); //**  curr processing */
                getCombinationSum2(i + 1 /*next*/, candidates, target, combination, prevSum + candidates[i] /**  curr processing */, answer);
                combination.remove(combination.size() - 1);
                while (i < candidates.length - 1 && candidates[i + 1] == candidates[i]) {
                    i++;
                }
            }
        }
    }

    public void dfs(int idx, int[] candidates, int target, List<Integer> combination, int sum, List<List<Integer>> answer) {


        if (sum == target) {  //sum
            answer.add(new ArrayList<>(combination));
            return;
        }

        if (idx >= candidates.length || sum > target) {
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            combination.add(candidates[i]);
            dfs(i + 1, candidates, target, combination, sum + candidates[i], answer);
            combination.remove(combination.size() - 1);
            while (i < candidates.length - 1 && candidates[i + 1] == candidates[i]) {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        Recur_CombinationSum_II_40 c2 = new Recur_CombinationSum_II_40();
        System.out.println(c2.combinationSum2(new int[]{2, 3, 4, 6, 7}, 7)); // {3,4}, {7}
        System.out.println(c2.combinationSum2(new int[]{2, 3, 6, 7}, 1)); // {}
        System.out.println(c2.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8)); // [1, 1, 6],  [1, 2, 5], [1, 7], [2, 6]
    }
}
