/*
You are given an array people where people[i] is the weight of the ith person,
and an infinite number of boats where each boat can carry a maximum weight of limit.
 Each boat carries at most two people at the same time, provided the sum of the weight of those people
 is at most limit.

Return the minimum number of boats to carry every given person.



Example 1:

Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)
Example 2:

Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)
Example 3:

Input: people = [3,5,3,4], limit = 5
Output: 4
Explanation: 4 boats (3), (3), (4), (5)


Constraints:

1 <= people.length <= 5 * 104
1 <= people[i] <= limit <= 3 * 104
 */


import java.util.Arrays;

public class BoatsToSavePeople_881 {


    //Time: O(nlogn) //sorting and reading input.
    //Space: O(logn) //sorting.
    //Greedy approach with 2 pointers/ two pointers.
    public int numRescueBoats(int[] people, int limit) {

        int boats=0;

        Arrays.sort(people);

        int i =0, j = people.length-1;  //2 pointers - one for lightest and one for heaviest.

        while( i < j){
            boats++;  // take one boat  - heaviest only fits or (heaviest + lightest) fits
            if(people[i] + people[j] <= limit){ // if (heaviest + lightest) fits then move to next lightest and heaviest pair
                i++;
            }
            j--;  // heaviest will take boat by himself or along with the lightest so in any case decrement j.
        }
        if(i==j){  // in case one person left then he needs one boat.
            boats++;
        }

        return boats;
    }

    public static void main (String args[]){
        BoatsToSavePeople_881 b = new BoatsToSavePeople_881();
        System.out.println(b.numRescueBoats(new int[]{1,2}, 3)); // 1 boat  (1, 2)
        System.out.println(b.numRescueBoats(new int[]{3,2,2,1}, 3)); // 3 boats (1, 2), (2) and (3)
        System.out.println(b.numRescueBoats(new int[]{3,5,3,4}, 5)); // 4 boats (3), (3), (4), (5)
        System.out.println(b.numRescueBoats(new int[]{5,1,4,2}, 6)); // 2 boats**  (5,1), (4,2)
        System.out.println(b.numRescueBoats(new int[]{3,2,3,2,2}, 6)); // 3 boats**  (3), (3), (2,2,2)
        System.out.println(b.numRescueBoats(new int[]{2,2,2,2,2}, 10)); // 1 boats**  (2,2,2,2,2)
    }
}
