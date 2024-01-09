/*Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Implement the MovingAverage class:

MovingAverage(int size) Initializes the object with the size of the window size.
double next(int val) Returns the moving average of the last size values of the stream.


Example 1:

Input
["MovingAverage", "next", "next", "next", "next"]
[[3], [1], [10], [3], [5]]
Output
[null, 1.0, 5.5, 4.66667, 6.0]

Explanation
MovingAverage movingAverage = new MovingAverage(3);
movingAverage.next(1); // return 1.0 = 1 / 1
movingAverage.next(10); // return 5.5 = (1 + 10) / 2
movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3


Constraints:

1 <= size <= 1000
-105 <= val <= 105
At most 104 calls will be made to next.

 */

import java.util.LinkedList;
import java.util.Queue;

public class Moving_Average_from_Data_Stream_Queue_346 {

    Queue<Integer> queue;
    int size = 0;
    double sum = 0;
    double avg;

    public Moving_Average_from_Data_Stream_Queue_346(int size) {
        this.queue = new LinkedList<>();
        this.size = size;
    }

    public double next(int val) {
        queue.add(val);
        if (queue.size() > size) {
            sum = sum - queue.poll(); // Remove first element to maintain queue size and subtract its value from sum so that you have sum of remaining two elements.
        }
        sum = sum + val;
        avg = sum / queue.size();
        return avg;
    }

    public static void main(String[] args) {
        Moving_Average_from_Data_Stream_Queue_346 M1 = new Moving_Average_from_Data_Stream_Queue_346(3);
        System.out.println(M1.next(1)); // 1/1 = 1
        System.out.println(M1.next(10)); // 1+10/2 = 5
        System.out.println(M1.next(3)); // (1 + 10 + 3) /3 = 4
        System.out.println(M1.next(5)); // (10 + 3 + 5)/3 = 6
    }
}
