package AppleLeetcode;
/*
Given two numbers, hour and minutes, return the smaller angle (in degrees) formed between the hour and the minute hand.

Answers within 10-5 of the actual value will be accepted as correct.



Example 1:


Input: hour = 12, minutes = 30
Output: 165
Example 2:


Input: hour = 3, minutes = 30
Output: 75
Example 3:


Input: hour = 3, minutes = 15
Output: 7.5


Constraints:

1 <= hour <= 12
0 <= minutes <= 59
Accepted
112.8K
Submissions
177.8K
Acceptance Rate
63.5%
Seen this question in a real interview before?
1/4
Yes
No
Discussion (9)
 */
public class AngleBetweenHandsofClock_1344 {

    public double angleClock(int hour, int minutes) {

        //hour hand -  12 hours - 360 degrees
        //              1 hour  - 360/12 =  30 degrees
        //              1 min   - 30/60 = 1/2 degree

        //degrees made by hour hand in hours time and minutes time
//        if(hour == 12)//if it is at 12, then it is starting point make it 0.
//            hour = 0;
//        double hourHandDegrees = hour * 30 + ((double)minutes * 1/2);  //convert minutes value to double otherwise the division on it loses the precision value.
        double hourHandDegrees = hour%12 * 30 + ((double)minutes * 1/2);  //convert minutes value to double otherwise the division on it loses the precision value.

        //minute hand -
        //              60 min  - 360 degrees
        //              1 min   - 6 degrees
        //degrees made by minute hand in minutes time
        double minuteHandDegrees = minutes * 6;

        double angle = Math.abs(hourHandDegrees - minuteHandDegrees);

        // If the angle is obtuse (>180), convert it to acute (0<=x<=180) because we want smaller angle as per quesiton.
        if (angle > 180) angle = 360.0 - angle;

        return angle;
    }
}
