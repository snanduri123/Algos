/*
You have n bags numbered from 0 to n - 1. You are given two 0-indexed integer arrays capacity and rocks. The ith bag can hold a maximum of capacity[i] rocks and currently contains rocks[i] rocks. You are also given an integer additionalRocks, the number of additional rocks you can place in any of the bags.

Return the maximum number of bags that could have full capacity after placing the additional rocks in some bags.



Example 1:

Input: capacity = [2,3,4,5], rocks = [1,2,4,4], additionalRocks = 2
Output: 3
Explanation:
Place 1 rock in bag 0 and 1 rock in bag 1.
The number of rocks in each bag are now [2,3,4,4].
Bags 0, 1, and 2 have full capacity.
There are 3 bags at full capacity, so we return 3.
It can be shown that it is not possible to have more than 3 bags at full capacity.
Note that there may be other ways of placing the rocks that result in an answer of 3.
Example 2:

Input: capacity = [10,2,2], rocks = [2,2,0], additionalRocks = 100
Output: 3
Explanation:
Place 8 rocks in bag 0 and 2 rocks in bag 2.
The number of rocks in each bag are now [10,2,2].
Bags 0, 1, and 2 have full capacity.
There are 3 bags at full capacity, so we return 3.
It can be shown that it is not possible to have more than 3 bags at full capacity.
Note that we did not use all of the additional rocks.


Constraints:

n == capacity.length == rocks.length
1 <= n <= 5 * 104
1 <= capacity[i] <= 109
0 <= rocks[i] <= capacity[i]
1 <= additionalRocks <= 109
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumBagsWithFullCapacityOFRocks_2279 {


    //Time: O(n⋅logn)
    //Space: O(n)
    // using Arrays.
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] remCap = new int[capacity.length];
        for (int i = 0 ; i < capacity.length ; i++) {
            remCap[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(remCap);

        int bags = 0;
        for (int cap : remCap) {
            if (additionalRocks >= cap) {
                bags++;
                additionalRocks -=cap;
            } else {
                break;
            }
        }
        return bags;
    }

    //Time: O(n⋅logn)
    //Space: O(n)
    // using PQ
    public int maximumBags2(int[] capacity, int[] rocks, int additionalRocks) {

        PriorityQueue<Integer> remCap = new PriorityQueue<>((a, b) -> a - b); //array is faster than PQ

        int fullCapBags = 0;

        for (int i = 0; i < capacity.length; i++) {
            remCap.add(capacity[i] - rocks[i]);
        }

        while (!remCap.isEmpty() && additionalRocks > 0) {

            int remainingCap = remCap.poll();
            if (remainingCap != 0) {
                if (remainingCap <= additionalRocks) {
                    additionalRocks = additionalRocks - remainingCap;
                } else {
                    //additionalRocks = 0;
                    break;
                }
            }
            fullCapBags++;  // if already a bag is full even before putting additional rocks
                            // or if a bag became full after adding additional rock.
        }

        return fullCapBags;
    }

    public static void main(String[] args) {
        MaximumBagsWithFullCapacityOFRocks_2279 m = new MaximumBagsWithFullCapacityOFRocks_2279();
        System.out.println(m.maximumBags(new int[]{2, 3, 4, 5}, new int[]{1, 2, 4, 4}, 2)); //3
        System.out.println(m.maximumBags(new int[]{10, 2, 2}, new int[]{2, 2, 0}, 100)); //3
        System.out.println(m.maximumBags(new int[]{2, 4}, new int[]{0, 0}, 1)); //0
    }
}
