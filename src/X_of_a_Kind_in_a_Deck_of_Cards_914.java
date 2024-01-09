/*
In a deck of cards, each card has an integer written on it.

Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:

Each group has exactly X cards.
All the cards in each group have the same integer.


Example 1:

Input: [1,2,3,4,4,3,2,1]
Output: true
Explanation: Possible partition [1,1],[2,2],[3,3],[4,4]
Example 2:

Input: [1,1,1,2,2,2,3,3]
Output: false
Explanation: No possible partition.
 */

import java.util.HashMap;
import java.util.Map;

public class X_of_a_Kind_in_a_Deck_of_Cards_914 {

    public boolean hasGroupsSizeX(int[] deck) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : deck) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        int count = map.get(deck[0]);

        if (count < 2) return false;



        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() != count) {
                if (entry.getValue() % count != 0) {   //Eg: if count = 2 and some card has count 4 then that means that number can be divided into two groups with two count each
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        X_of_a_Kind_in_a_Deck_of_Cards_914 k = new X_of_a_Kind_in_a_Deck_of_Cards_914();
        System.out.println(k.hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1})); //true
        System.out.println(k.hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3})); //false
        System.out.println(k.hasGroupsSizeX(new int[]{1})); //false
        System.out.println(k.hasGroupsSizeX(new int[]{1, 1})); //true
        System.out.println(k.hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2})); //true
        System.out.println(k.hasGroupsSizeX(new int[]{1,1,1,1,2,2,2,2,2,2})); //true

    }
}
