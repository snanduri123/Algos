import java.util.*;

/*
A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
Note:

S will have length in range [1, 500].
S will consist of lowercase letters ('a' to 'z') only.

 */
public class Partition_Labels_763 {


    public static void main(String[] args) {
        Partition_Labels_763 p = new Partition_Labels_763();

        System.out.println(p.partitionLabels("ababcbacadefegdehijhklij")); // [9,7,8]

        System.out.println(p.partitionLabels("eccbbbbdec")); // [9,7,8]
    }

    //Time - nlogn + n + n = nlogn; space is constant because 26.
    public List<Integer> partitionLabels(String S) {

        List<Integer> partitionLengths = new ArrayList<>();

        //track the start position and end position of every character in the string in the form of Interval object
        //ArrayList<Interval> intervals = new ArrayList<>(26);
        List<Interval> intervals = Arrays.asList(new Interval[26]);

        for (int i = 0; i < S.length(); i++) {
            int pos = S.charAt(i) - 'a';
            if (intervals.size() > pos) {
                intervals.get(pos).end = i;
            } else {
                intervals.add(pos, new Interval(i, i));
            }
        }

        //sort all intervals in ascending order by start position of all intervals
        IntervalComparator comparator = new IntervalComparator();
        Collections.sort(intervals, comparator);  //nlogn

        //merge intervals
        List<Interval> mergedIntervals = merge(intervals); //n

        //find the length of each interval       //n
        for (Interval interval : mergedIntervals) {
            int length = (interval.end - interval.start) + 1; //adding 1 because start is start position and it should be considered to calculate length
            partitionLengths.add(length);
        }
        return partitionLengths;
    }

    public List<Interval> merge(List<Interval> intervals) {

        LinkedList<Interval> merged = new LinkedList<Interval>();
        for (Interval interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        return merged;
    }
}
