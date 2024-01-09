/*
Given an array of meeting time intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1


Constraints:

1 <= intervals.length <= 104
0 <= starti < endi <= 106
 */


import java.util.Arrays;
import java.util.PriorityQueue;

public class Meeting_rooms_II_number_PQ_253 {

    //Time : O(nlogn)
    //Space: O(n)
    public int minMeetingRooms(int[][] intervals) {

        int count = 0;

        if (intervals.length == 0 || intervals.length == 1)
            return intervals.length;

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]); //sort by start time to see which meeting starts first

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]); //sort by end time to see which meeting ends first before adding considering new meeting.

        for(int i = 0 ; i <= intervals.length - 1; i++) {

            //if there is meeting (top on priority queue because it has smaller end time) still going on
            // then we need new meeting room. If that meeting is ended then we can free up that room and
            // give it to the current meeting without using new room.
            if (pq.isEmpty() || (pq.peek()[1] > intervals[i][0])){
                count++;
            }
            else{
                pq.poll(); //the meeting that ends first is on top, so remove it.
            }
            pq.add(intervals[i]);

        }
        return count;
    }

    public static void main(String[] args){

        Meeting_rooms_II_number_PQ_253 m = new Meeting_rooms_II_number_PQ_253();
        System.out.println(m.minMeetingRooms(new int[][]{{1, 4}, {4, 5}})); // 1 - lists having equal start and end intervals i.e, no overlapping.
        System.out.println(m.minMeetingRooms(new int[][]{{1, 2}, {3, 5}, {4, 5}})); // 2 - start time of one meeting has overlapping with other
        System.out.println(m.minMeetingRooms(new int[][]{{4, 9}, {9,10}, {4, 17}})); //* 2 - all meetings have overlap but anytime only 2 are overlapped so only 2 (not 3) meeting rooms are required
        System.out.println(m.minMeetingRooms(new int[][]{{1, 4}, {5, 6}})); //1  1 overlapping
        System.out.println(m.minMeetingRooms(new int[][]{{1, 3}, {2, 6}, {8, 10}})); //2 - end time of one meeting has overlapping with other
        System.out.println(m.minMeetingRooms(new int[][]{{1, 4}, {2, 3}})); //2  -  second element start and end are smaller than first element end
    }
}
