/*
You are given a 2D integer array logs where each logs[i] = [birthi, deathi] indicates the birth and death years of the ith person.

The population of some year x is the number of people alive during that year. The ith person is counted in year x's population if x is in the inclusive range [birthi, deathi - 1]. Note that the person is not counted in the year that they die.

Return the earliest year with the maximum population.



Example 1:

Input: logs = [[1993,1999],[2000,2010]]
Output: 1993
Explanation: The maximum population is 1, and 1993 is the earliest year with this population.
Example 2:

Input: logs = [[1950,1961],[1960,1971],[1970,1981]]
Output: 1960
Explanation:
The maximum population is 2, and it had happened in years 1960 and 1970.
The earlier year between them is 1960.


Constraints:

1 <= logs.length <= 100
1950 <= birthi < deathi <= 2050
 */

import java.util.HashSet;
import java.util.Set;

public class MaximumPopulationYear_1854 {

    //Time : O(n)
    //Space: O(k) //constant space of size 2050
    //line sweep algorithm. (Marking start and end times.) Faster than below method because you skip visiting years in between life and death while traversing logs.
    public int maximumPopulation(int[][] logs) {
        int[] year = new int[2051];
        int max = Integer.MIN_VALUE;
        int maxYear = 1950;

        for (int[] log : logs) {
            int birth = log[0];
            int death = log[1];
            year[birth] = year[birth] + 1;   // for each person mark when he is born
            year[death] = year[death] - 1;  // for each person mark when he died.
        }

        for (int i = 1951; i < 2051; i++) {
            year[i] = year[i] + year[i-1]; //Each year we check if any previously born person is living still by checking previous value and add it to current value.
            if (year[i] > max) {
                max = year[i];
                maxYear = i;
            }
        }
        return maxYear;
    }


    //
    public int maximumPopulation2(int[][] logs) {
        int[] fullLog = new int[2050]; //

        int max = Integer.MIN_VALUE;
        int maxYear = 0;

        for (int[] log : logs) {
            int birth = log[0];
            int death = log[1];
            for (int i = birth; i < death; i++) {
                fullLog[i] = fullLog[i] + 1;   // for each person lived through years, add 1 for each of those years.
                                               // This makes slow. Skip going through all the years in between birth and death by using above line sweep algorithm
            }
        }

        for (int i = 1951; i < 2050; i++) {
            if (fullLog[i] > max) {
                max = fullLog[i];
                maxYear = i;
            }
        }
        return maxYear;
    }

    public static void main(String[] args) {
        MaximumPopulationYear_1854 m = new MaximumPopulationYear_1854();
        System.out.println(m.maximumPopulation(new int[][]{new int[]{1993, 1999}, new int[]{2000, 2010}})); //1993
        System.out.println(m.maximumPopulation(new int[][]{new int[]{1950, 1961}, new int[]{1960, 1971}, new int[]{1970, 1981}})); //1960. maximum population is 2, and it had happened in years 1960 and 1970. But 1960 is earlier between them.
    
    }
}
