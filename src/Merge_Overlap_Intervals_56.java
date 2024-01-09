import java.util.*;

/*
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

 */
//Time Complexity : nlogn
//Space Complexity : n
public class Merge_Overlap_Intervals_56 {

// NOTE:  Moved this class as separate class so that this comparator can be used by other classes.
// class IntervalComparator implements Comparator<Interval> {
//
//        // -ve means i1 is smaller
//        // +ve means i1 is greater
//        // 0 means both are equal
//        public int compare(Interval i1, Interval i2) {
//            return i1.start - i2.start;
//        }
//    }

    public List<Interval> merge2(List<Interval> intervals) {


        if (intervals == null || intervals.isEmpty() || intervals.size() == 1) {
            return intervals;
        }
        //sort all intervals so that they are arranged in the ascending order of "start" value of each interval object
        IntervalComparator comparator = new IntervalComparator();
        Collections.sort(intervals, comparator);  //O(nlogn)

        List<Interval> result = new ArrayList<>();

        result.add(intervals.get(0));
        Interval prevInterval = result.get(0);

        for (int i = 1; i < intervals.size(); i++) {  //O(n)

            if (intervals.get(i).start <= prevInterval.end) {
                if (intervals.get(i).end >= prevInterval.end) { // if second element's end is greater than previous element's end then consider second element's end
                    prevInterval.end = intervals.get(i).end;
                }
            } else {
                result.add(intervals.get(i));
                prevInterval = result.get(result.indexOf(intervals.get(i)));
            }

        }

        return result;
    }

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator()); //O(nlogn)

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


    //Time: sort + going through all intervals - n + nlogn = O(nlogn)
    //Space: O(n)
    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0)
            return new int[0][];

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        int[] prevInterval = intervals[0];
        result.add(prevInterval);

        for (int i = 1; i <= intervals.length - 1; i++) {
            int[] newInterval;
            //if previous meeting starts on or after next meeting  OR if a meeting ends after next meeting starts then there is overlap, so merge them by updating the end time of previous meeting with maximum of both meeting's end times.
            if (prevInterval[0] == intervals[i][0] ||  prevInterval[1] >= intervals[i][0]) {
                prevInterval[1] = Math.max(prevInterval[1], intervals[i][1]);
//                newInterval = new int[]{prevInterval[0], Math.max(prevInterval[1], intervals[i][1])};
//                result.remove(prevInterval);
            } else {
                newInterval = new int[]{intervals[i][0], intervals[i][1]};
                result.add(newInterval);
                prevInterval = newInterval;
            }
        }

        int[][] ans = new int[result.size()][];
        int i = 0;
        for (int[] interval : result) {
            ans[i] = interval;
            i++;
        }

        return ans;

    }

    public static void main(String[] args) {
        Merge_Overlap_Intervals_56 m = new Merge_Overlap_Intervals_56();
        List<Interval> l1 = m.merge(Arrays.asList());  //empty input
        List<Interval> l2 = m.merge(Arrays.asList(new Interval(1, 4), new Interval(4, 5))); // lists having equal start and end intervals
        List<Interval> l3 = m.merge(Arrays.asList(new Interval(1, 2), new Interval(3, 5), new Interval(4, 5))); //overlapping
        List<Interval> l4 = m.merge(Arrays.asList(new Interval(1, 4), new Interval(5, 6))); //no overlapping
        List<Interval> l5 = m.merge(Arrays.asList(new Interval(1, 3), new Interval(2, 6), new Interval(8, 10))); // first element has overlapping
        List<Interval> l6 = m.merge(Arrays.asList(new Interval(1, 4), new Interval(2, 3))); // second element start and end are smaller than first element end

        //using arrays method.
   //     System.out.println(Arrays.deepToString(m.merge(new int[0][])));  //empty input
        System.out.println(Arrays.deepToString(m.merge(new int[][]{{1, 4}, {4, 5}}))); // [1,5] - lists having equal start and end intervals
        System.out.println(Arrays.deepToString(m.merge(new int[][]{{1, 2}, {3, 5}, {4, 5}}))); // [1,2],[3,5] start time of one meeting has overlapping with other
        System.out.println(Arrays.deepToString(m.merge(new int[][]{{1, 4}, {5, 6}}))); //[1,4], [5,6]  no overlapping
        System.out.println(Arrays.deepToString(m.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}}))); //[1,6], [8,10] - end time of one meeting has overlapping with other
        System.out.println(Arrays.deepToString(m.merge(new int[][]{{1, 4}, {2, 3}}))); //[1,4] second element start and end are smaller than first element end
    }
}
