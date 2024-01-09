/*
The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.


Example 1:

Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0


Constraints:

-105 <= num <= 105
There will be at least one element in the data structure before calling findMedian.
At most 5 * 104 calls will be made to addNum and findMedian.


Follow up:

If all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
 */


import java.util.PriorityQueue;

public class Find_Median_from_Data_Stream_295 {


    static class MedianFinder{
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();  //holds bigger elements compared to minPQ whenever a new element has to be added then top (smallest is removed)
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a,b) -> b-a);  //holds smaller elements compared to minPQ


        //Time: O(logn)
        //Try to keep both heaps equally balanced or have utmost different of 1 element.
        public void addNum(int num){
            if(maxPQ.isEmpty() || num < maxPQ.peek()){ //bigger elements on the top of heap (exit first)
                maxPQ.add(num);
                if(maxPQ.size() - minPQ.size() > 1){  //or maxPQ.size() - minPQ.size() == 2
                    minPQ.add(maxPQ.poll());
                }
            }else{
                minPQ.add(num);
                if(minPQ.size() - maxPQ.size() > 1) {
                    maxPQ.add(minPQ.poll());
                }
            }
        }

        //Time : O(1)
        public double findMedian(){
            if(minPQ.size() == maxPQ.size()){
                double median = ((double)minPQ.peek()  + (double)maxPQ.peek())/2;
                return median;
            }
            else if(minPQ.size() > maxPQ.size()){
                return minPQ.peek();
            }else{
                return maxPQ.peek();
            }
        }
    }

    public static void main(String[] args){
        MedianFinder m = new MedianFinder();
        m.addNum(1);
        m.addNum(2);
        System.out.println(m.findMedian());
        m.addNum(3);
        System.out.println(m.findMedian());
    }
}
