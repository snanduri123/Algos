/*
Given the availability time slots arrays slots1 and slots2 of two people and a meeting duration duration,
return the earliest time slot that works for both of them and is of duration duration.

If there is no common time slot that satisfies the requirements, return an empty array.

The format of a time slot is an array of two elements [start, end] representing an inclusive time range from start to end.

It is guaranteed that no two availability slots of the same person intersect with each other.
That is, for any two time slots [start1, end1] and [start2, end2] of the same person, either start1 > end2 or start2 > end1.



Example 1:

Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
Output: [60,68]


Example 2:

Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
Output: []


Constraints:

1 <= slots1.length, slots2.length <= 104
slots1[i].length, slots2[i].length == 2
slots1[i][0] < slots1[i][1]
slots2[i][0] < slots2[i][1]
0 <= slots1[i][j], slots2[i][j] <= 109
1 <= duration <= 106
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingScheduler_1229 {

    //Time: O(nlogn) + O(mlogm) + n + m
    //Space: O(1) - no extra space used other than for storing answer.

    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> ans = new ArrayList<>();

        Arrays.sort(slots1, (a, b) -> a[0] - b[0]); // sort slots1 intervals in ascending order by start time
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]); // sort slots2 intervals in ascending order by start time

        for (int i = 0, j = 0; i < slots1.length && j < slots2.length; ) {

            //find overlap
            int overlapStart = Math.max(slots1[i][0], slots2[j][0]);
            int overlapEnd = Math.min(slots1[i][1], slots2[j][1]);

            //check if there is overlap (overlap start < overlap end) and check if the overlap has enough duration
            if ((overlapStart <= overlapEnd) && (overlapStart + duration <= overlapEnd)) {
                ans.add(overlapStart);
                ans.add(overlapStart + duration);
                return ans;
            }

            // if there is no overlap OR
            // if there is overlap but not enough duration then
            //     go to next interval in the slot whose current interval's end time is smaller than other slot interval's end time
            if (slots1[i][1] < slots2[j][1])  // if slot1 current interval's end time is smaller than slot2 current interval's end time
                i++;                          //     then go to next interval in the same slot.
            else
                j++;
        }
        return ans;
    }


    public static void main(String[] args) {
        MeetingScheduler_1229 m = new MeetingScheduler_1229();

        System.out.println(m.minAvailableDuration(new int[][]{{10, 12}, {15, 25}},
                new int[][]{{0, 100}}, 10)); // [15,25]



            /*1a1. overlap with enough duration for multiple slot1 and slot 2 intervals but we need the earliest.
             So we need to SORT slot1 intervals and slot2 intervals.
                  ---------------
                  10            50
            ---------
            0       15
           */

        System.out.println(m.minAvailableDuration(new int[][]{{216397070, 363167701}, {98730764, 158208909}, {441003187, 466254040}, {558239978, 678368334}, {683942980, 717766451}},
                new int[][]{{50490609, 222653186}, {512711631, 670791418}, {730229023, 802410205}, {812553104, 891266775}, {230032010, 399152578}}, 456085)); // [98730764, 99186849]


        /*1a. overlap with enough duration but slot1 interval start's later to slot 2 interval
                  ---------------
                  10            50
            ---------
            0       15
         */
        System.out.println(m.minAvailableDuration(new int[][]{{10, 50}, {60, 120}, {140, 210}}, new int[][]{{0, 15}, {60, 70}}, 8)); // [60,68]

        /*1b. overlap with enough duration but slot2 interval start's later to slot 1 interval

            ---------
            0       15
                  ---------------
                  10            50
         */
        System.out.println(m.minAvailableDuration(new int[][]{{0, 15}, {60, 70}}, new int[][]{{10, 50}, {60, 120}, {140, 210}}, 8)); // [60,68]

        /*2a. overlap with enough duration, both slots start at same time but end at different times.(end2 > end1)

            ---------
            0       15
            ---------------
            0            50
         */
        System.out.println(m.minAvailableDuration(new int[][]{{0, 15}, {60, 70}}, new int[][]{{0, 50}, {60, 120}, {140, 210}}, 15)); // [0,15]


        /*2b. overlap with enough duration, both slots start at same time but end at different times. (end1 > end2)

            ---------------
            0            50
            ---------
            0       15

         */
        System.out.println(m.minAvailableDuration(new int[][]{{0, 50}, {60, 120}, {140, 210}}, new int[][]{{0, 15}, {60, 70}}, 15)); // [0,15]

        /*3a. overlap with enough duration; one slot completely overlaps other

            ---------------
            0             50
               ------
               10   15

         */
        System.out.println(m.minAvailableDuration(new int[][]{{0, 50}, {60, 120}, {140, 210}}, new int[][]{{10, 15}, {60, 70}}, 4)); // [10,14]

        /*4a.

            ---------------
            10             50
            ---------------
            10             50

         */
        System.out.println(m.minAvailableDuration(new int[][]{{10, 50}, {60, 120}, {140, 210}}, new int[][]{{10, 50}, {60, 70}}, 40)); // [10,50]

        /*5a.   -- no overlap

            ---------------
            10             50
                            ---------------
                            50             80

         */
        System.out.println(m.minAvailableDuration(new int[][]{{10, 50}, {60, 120}, {140, 210}}, new int[][]{{0, 15}, {60, 70}}, 12)); // []

        /*5a.   -- overlap but not enough duration (12 min)

            ---------------   -------------------------
            10             50 60                      120
                              -------       -------
                              60    70      100   110

         */
        System.out.println(m.minAvailableDuration(new int[][]{{10, 50}, {60, 120}, {140, 210}}, new int[][]{{0, 15}, {60, 70}, {100, 110}}, 12)); // []

        /*6.   -- no overlap

            ---------------
            10             50
                             --------
                             60      70

         */
        System.out.println(m.minAvailableDuration(new int[][]{{10, 50}, {80, 120}, {140, 210}}, new int[][]{{0, 15}, {60, 70}}, 10)); // []
    }
}
