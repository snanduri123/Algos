/*
Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.



Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: false
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: true

 */

import java.util.Arrays;

public class Meeting_Rooms_Overlap_252 {

    //Time : O(nlogn)
    //Space: O(1)
    public boolean canAttendMeetings(int[][] intervals) {

        //sort by starting time of the meeting intervals.
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for(int i = 1 ; i < intervals.length; i++) {

            //if a meeting starts on or after next meeting  OR if a meeting ends after next meeting starts then there is overlap, so return false.
            if(intervals[i][0] == intervals[i-1][1] ||
                    intervals[i][0] < intervals[i-1][1])
                return false;
        }
        return true;
    }

    public static void main(String[] args){

        Meeting_Rooms_Overlap_252 m = new Meeting_Rooms_Overlap_252();
        System.out.println(m.canAttendMeetings(new int[][]{{1, 4}, {4, 5}})); // false-  meetings having equal start and end intervals i.e, overlapping.
        System.out.println(m.canAttendMeetings(new int[][]{{1, 2}, {3, 5}, {4, 5}})); // false - start time of one meeting has overlapping with other
        System.out.println(m.canAttendMeetings(new int[][]{{4, 9}, {9,10}, {4, 17}})); //false - all meetings have overlap but anytime only 2 are overlapped so only 2 (not 3) meeting rooms are required
        System.out.println(m.canAttendMeetings(new int[][]{{1, 4}, {5, 6}})); //true  -  no overlap
        System.out.println(m.canAttendMeetings(new int[][]{{1, 3}, {2, 6}, {8, 10}})); //false - end time of one meeting has overlapping with other
    }
}
