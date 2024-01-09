/*You have a water dispenser that can dispense cold, warm, and hot water. Every second, you can either fill up 2 cups with different types of water, or 1 cup of any type of water.

You are given a 0-indexed integer array amount of length 3 where amount[0], amount[1], and amount[2] denote the number of cold, warm, and hot water cups you need to fill respectively. Return the minimum number of seconds needed to fill up all the cups.

Example 1:

Input: amount = [1,4,2]
Output: 4
Explanation: One way to fill up the cups is:
Second 1: Fill up a cold cup and a warm cup.
Second 2: Fill up a warm cup and a hot cup.
Second 3: Fill up a warm cup and a hot cup.
Second 4: Fill up a warm cup.
It can be proven that 4 is the minimum number of seconds needed.
Example 2:

Input: amount = [5,4,4]
Output: 7
Explanation: One way to fill up the cups is:
Second 1: Fill up a cold cup, and a hot cup.
Second 2: Fill up a cold cup, and a warm cup.
Second 3: Fill up a cold cup, and a warm cup.
Second 4: Fill up a warm cup, and a hot cup.
Second 5: Fill up a cold cup, and a hot cup.
Second 6: Fill up a cold cup, and a warm cup.
Second 7: Fill up a hot cup.
Example 3:

Input: amount = [5,0,0]
Output: 5
Explanation: Every second, we fill up a cold cup.


Constraints:

amount.length == 3
0 <= amount[i] <= 100
 */

import java.util.PriorityQueue;

public class Minimum_Amount_of_Time_to_Fill_Cups_2335 {

    public int fillCups(int[] amount) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int amt : amount) {
            if(amt > 0) {
                pq.add(amt);
            }
        }

        int count = 0;
        while (pq.size() > 1) {
            int item1 = pq.poll();
            int item2 = pq.poll();

            item1 = item1 - 1;
            item2 = item2 - 1;

            if (item1 > 0) {
                pq.add(item1);
            }

            if (item2 > 0) {
                pq.add(item2);
            }
            count++;
        }
        if (pq.size() == 1) //at the end if there is only one item left then for that item those many single times we need to dispense.
        {
            count = count + pq.poll();
        }
        return count;
    }

    public static void main(String[] args) {
        Minimum_Amount_of_Time_to_Fill_Cups_2335 M = new Minimum_Amount_of_Time_to_Fill_Cups_2335();
        System.out.println(M.fillCups(new int[]{0,0,0})); //0
        System.out.println(M.fillCups(new int[]{1,4,2})); //4
        System.out.println(M.fillCups(new int[]{5,4,4})); //7
        System.out.println(M.fillCups(new int[]{6,4,4})); //7
        System.out.println(M.fillCups(new int[]{7,4,4})); //8
        System.out.println(M.fillCups(new int[]{8,4,4})); //8   //at the end there will be one item left with 1 dispenses
        System.out.println(M.fillCups(new int[]{9,4,4})); //9    //at the end there will be one item left with > 1 dispenses
    }

}
