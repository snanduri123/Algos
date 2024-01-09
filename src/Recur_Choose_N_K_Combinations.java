/*
Given two integers n and k, find all the possible unique combinations of k numbers in range 1 to n.

Example One
{
"n": 5,
"k": 2
}
Output:

[
[1, 2],
[1, 3],
[1, 4],
[1, 5],
[2, 3],
[2, 4],
[2, 5],
[3, 4],
[3, 5],
[4, 5]
]
Example Two
{
"n": 6,
"k": 6
}
Output:

[
[1, 2, 3, 4, 5, 6]
]
Notes
The answer can be returned in any order.

Constraints:

1 <= n <= 20
1 <= k <= n
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Recur_Choose_N_K_Combinations {

    ArrayList<ArrayList<Integer>> answer;

    public ArrayList<ArrayList<Integer>> find_combinations(Integer n, Integer k) {
        answer = new ArrayList<>();
        find_combinations(n, k, 1, new ArrayList<>(), answer);
        return answer;
    }

    //Time : n * 2^n (n = to create combination of n characters or output to answer, 2^n nodes are created to get the answer)
    //space: O(n) - height of the tree. Each time we create one answer string and need n memory
    public void find_combinations1(Integer n, Integer k, int pos,
                                   ArrayList<Integer> currComb,
                                   ArrayList<ArrayList<Integer>> answer) {
        if (currComb.size() == k) {
            ArrayList<Integer> list = new ArrayList<>(currComb);  //this is the combination creation.
            answer.add(list);
            return;
        }

        for (int i = pos; i <= n; i++) {
            currComb.add(i);
            find_combinations(n, k, i + 1, currComb, answer);
            currComb.remove(currComb.size() - 1);
        }
    }

    //Time : n * 2^n (n = to create combination of n characters or output to answer, 2^n nodes are created to get the answer)
    //space: O(n) - height of the tree. Each time we create one answer string and need n memory
    //This uses exclude - include pattern gives output in random order and this pattern in general does not work for other problems with input having duplicates
    public void find_combinations(Integer n, Integer k, int pos,
                                  ArrayList<Integer> currComb,
                                  ArrayList<ArrayList<Integer>> answer) {
        if (currComb.size() == k) {
            ArrayList<Integer> list = new ArrayList<>(currComb);  //this is the combination creation.
            answer.add(list);
            return;
        }

        if (pos > n) {
            return;
        }

        //exclude: exclude current number and find combinations with the rest of the numbers.
        find_combinations(n, k, pos + 1, currComb, answer);

        //include
        currComb.add(pos);
        find_combinations(n, k, pos + 1, currComb, answer);
        currComb.remove(currComb.size() - 1);
    }

    public static void main(String[] args) {
        Recur_Choose_N_K_Combinations n = new Recur_Choose_N_K_Combinations();
        System.out.println(Arrays.deepToString(n.find_combinations(5, 2).toArray())); //[[1, 2], [1, 3], [1, 4], [1, 5], [2, 3], [2, 4], [2, 5], [3, 4], [3, 5], [4, 5]]
        System.out.println(Arrays.deepToString(n.find_combinations(5, 4).toArray())); //[[2, 3, 4, 5], [1, 3, 4, 5], [1, 2, 4, 5], [1, 2, 3, 5], [1, 2, 3, 4]]
        System.out.println(Arrays.deepToString(n.find_combinations(3, 3).toArray())); //[[1, 2, 3]]
    }
}
