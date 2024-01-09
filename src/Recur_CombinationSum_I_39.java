/*
Given an array of distinct integers candidates and a target integer target,
 return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
frequency
 of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.



Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []


Constraints:

1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40
 */

import java.util.ArrayList;
import java.util.List;

public class Recur_CombinationSum_I_39 {

    //Time: exponential (2^n)
    List<List<Integer>> answer;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Arrays.sort(candidates);
        answer = new ArrayList<>();
        //dfs1( 0,  candidates, target, new ArrayList<>(),   0,  answer);
        dfs(0, candidates, target, new ArrayList<>(), 0);
        return answer;
    }

    public void dfs(int pos, int[] candidates, int target, List<Integer> currList, int currSum) {
        if (currSum > target) {
            return;
        }

        if (currSum == target) {
            List<Integer> ans = new ArrayList<>(currList);
            answer.add(ans);
        }

        for (int i = pos; i < candidates.length; i++) {
            currList.add(candidates[i]);
            dfs(i, candidates, target, currList, currSum + candidates[i]);
            currList.remove(currList.size() - 1);
        }
    }

    public void dfs1(int idx, int[] candidates, int target, List<Integer> combination, int sum) {

        if (sum == target) {  //successful base condition
            answer.add(new ArrayList<>(combination));
            return;
        }

        if (idx >= candidates.length || sum > target) {  //unsuccessful base condition
            return;
        }

        combination.add(candidates[idx]);
        dfs1(idx, candidates, target, combination, candidates[idx] + sum);
        combination.remove(combination.size() - 1);
        dfs1(idx + 1, candidates, target, combination, sum);
    }

    public void dfs2(int idx, int[] candidates, int target, List<Integer> combination, int prevSum, List<List<Integer>> answer) {
        if (prevSum == target) {
            answer.add(new ArrayList<>(combination));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            int currentSum = prevSum + candidates[i];
            if (currentSum <= target) {
                combination.add(candidates[i]);
                dfs2(i, candidates, target, combination, currentSum, answer);
                combination.remove(combination.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Recur_CombinationSum_I_39 c = new Recur_CombinationSum_I_39();
        System.out.println(c.combinationSum(new int[]{2, 3, 6, 7}, 7)); // {2,2,3}, {7}
        System.out.println(c.combinationSum(new int[]{2, 3, 6, 7}, 1)); // {}
        System.out.println(c.combinationSum(new int[]{2, 3, 5, 7}, 7)); // {2,2,3}, {2,5}, {7}
        System.out.println(c.combinationSum(new int[]{5, 3, 2, 7}, 7)); // (not ascending order input) [[5, 2], [3, 2, 2], [7]]
        // System.out.println(c.combinationSum(new int[] {2,3,6,7}, 1)); // {}
    }
}
