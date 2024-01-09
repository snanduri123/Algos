/*
You are given two arrays of strings that represent two inclusive events that happened on the same day, event1 and event2, where:

event1 = [startTime1, endTime1] and
event2 = [startTime2, endTime2].
Event times are valid 24 hours format in the form of HH:MM.

A conflict happens when two events have some non-empty intersection (i.e., some moment is common to both events).

Return true if there is a conflict between two events. Otherwise, return false.



Example 1:

Input: event1 = ["01:15","02:00"], event2 = ["02:00","03:00"]
Output: true
Explanation: The two events intersect at time 2:00.
Example 2:

Input: event1 = ["01:00","02:00"], event2 = ["01:20","03:00"]
Output: true
Explanation: The two events intersect starting from 01:20 to 02:00.
Example 3:

Input: event1 = ["10:00","11:00"], event2 = ["14:00","15:00"]
Output: false
Explanation: The two events do not intersect.


Constraints:

evnet1.length == event2.length == 2.
event1[i].length == event2[i].length == 5
startTime1 <= endTime1
startTime2 <= endTime2
All the event times follow the HH:MM format.
 */

import java.time.LocalTime;
import java.util.Arrays;

public class Meeting_Events_Conflict_2446 {

    //Time : O(n)
    //Space: O(1)
    public boolean haveConflict(String[] event1, String[] event2) {
        //start and end times of event 1 should be either lesser than start time of second event or greater than second event
        // In other words, interval1 (start and end) should be completely lesser than interval 2 or completely greater than interval2

        if((event1[0].compareTo(event2[0]) < 0  && event1[1].compareTo(event2[0]) < 0)  ||
                (event1[0].compareTo(event2[1]) > 0  && event1[1].compareTo(event2[1]) > 0))
            return false;
        else
            return true;

        //or
        // if((event1[0].compareTo(event2[0]) < 0  && event1[1].compareTo(event2[0]) < 0)  ||
        //     (event2[0].compareTo(event1[0]) < 0  && event2[1].compareTo(event1[0]) < 0))
        //       return false;
        // else
        //    return true;
    }
}
