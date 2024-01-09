/*
Given an integer array nums of unique elements, return all possible
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recur_Subsets_78 {
    List<List<Integer>> answer;
    public List<List<Integer>> subsets(int[] nums) {
        answer = new ArrayList<>();
        find_subsets(nums, 0, new ArrayList<>());
        return answer;
    }


    //Time : n * 2^n (n = to create string of n characters or output to answer, 2^n nodes are created to get the answer)
    //space: O(n) - height of the tree. Each time we create one answer string and need n memory
    public void find_subsets(int[] nums, int pos, ArrayList<Integer> currSet) {

        //The below 2 lines are not base condition like in "Choose_N_K_Combinations" because, subset is of any length. (No length condition)
        ArrayList<Integer> list = new ArrayList<>(currSet); //*** adds first empty set {} also if we have these lines of code here instead of inside forloop.
        answer.add(list);
        //**** Notice there is no return statement here to break recursion ***
        for (int i = pos; i < nums.length; i++) { //*** i< nums.length condition breaks the recursion.
            currSet.add(nums[i]);
            find_subsets(nums, i + 1, currSet);
            //exclude curr element and check what other elements (that are following next to this in the input) can be placed in its place.
            currSet.remove(currSet.size() - 1);
        }
    }


    //Time : n * 2^n (n = to create string of n characters or output to answer, 2^n nodes are created to get the answer)
    //space: O(n) - height of the tree. Each time we create one answer string and need n memory
    //This uses exclude - include pattern gives output in random order and this pattern in general does not work for other problems with input having duplicates.
    public void find_subsets2(int[] nums, int pos, ArrayList<Integer> currSet) {
        if(pos == nums.length) {
            ArrayList<Integer> list = new ArrayList<>(currSet); //add first empty set {} also if we have these lines of code here instead of inside forloop.
            answer.add(list);
            return;
        }
        //exclude
        find_subsets2(nums, pos + 1, currSet);
        //include
        currSet.add(nums[pos]);
        find_subsets2(nums, pos + 1, currSet);
        currSet.remove(currSet.size() - 1);
    }

    public static void main(String[] args) {
        Recur_Subsets_78 n = new Recur_Subsets_78();
        System.out.println(Arrays.deepToString(n.subsets(new int[]{1, 2, 3}).toArray())); //[[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
    }
}
