package AppleLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.



Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.


Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
 */
public class MergeIntervals_56 {

    public int[][] merge(int[][] intervals){

        List<int[]> ans = new ArrayList<>();

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]); //sort

        ans.add(intervals[0]);  //just add first interval (to be previous interval), so that it can be merged with next if needed.
        int last = 0;  //remember the last seen idx. (or use size() -1 in the later code)

        for(int i = 1; i < intervals.length; i++){
            int[] prevInterval = ans.get(last);
            if(prevInterval[1] >= intervals[i][0]){ //merge the max(end tiem) if overlaps with previous interval
                prevInterval[1] = Math.max(prevInterval[1],intervals[i][1]);
               // ans.set(last, prevInterval); //*not needed. because prevInterval[1] is already updated and its reference is in ans arraylist, so arraylist also gets updated.
            }else {
                ans.add(intervals[i]);  //add this interval as-is to list because it does not overlap
                last++;
            }
        }

        int[][] answer = new int[ans.size()][];
        int i = 0;
        for(int[] interval: ans){ // convert list to size.
            answer[i] = interval;
            i++;
        }
        return answer;
    }


    public static void main(String[] args) {
        MergeIntervals_56 m = new MergeIntervals_56();

        //using arrays method.
        System.out.println(Arrays.deepToString(m.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15,18}}))); //[1,6], [8,10] - end time of one meeting has overlapping with other
        System.out.println(Arrays.deepToString(m.merge(new int[0][])));  //empty input
        System.out.println(Arrays.deepToString(m.merge(new int[][]{{1, 4}, {4, 5}}))); // [1,5] - lists having equal start and end intervals
        System.out.println(Arrays.deepToString(m.merge(new int[][]{{1, 2}, {3, 5}, {4, 5}}))); // [3,5],[4,5] start time of one meeting has overlapping with other
        System.out.println(Arrays.deepToString(m.merge(new int[][]{{1, 2}, {3, 5}, {4, 6}}))); // [3,5],[4,5] end time of one meeting has some overlapping with other
        System.out.println(Arrays.deepToString(m.merge(new int[][]{{1, 4}, {5, 6}}))); //[1,4], [5,6]  no overlapping
        System.out.println(Arrays.deepToString(m.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15,18}}))); //[1,6], [8,10] - end time of one meeting has overlapping with other
        System.out.println(Arrays.deepToString(m.merge(new int[][]{{1, 4}, {2, 3}}))); //[1,4] second element start and end are smaller than first element end
        System.out.println(Arrays.deepToString(m.merge(new int[][]{{1, 4}}))); //[1,4] single interval - no overlapping.
    }
}
