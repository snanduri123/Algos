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
public class Insert_New_Intervals_56 {
    //Time: sort + going through all intervals - n + nlogn = O(nlogn)
    //Space: O(n)
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> answer = new ArrayList<>();
        int[][] ansArr;
        boolean isNewIntervalUsed = false;

        for(int i=0; i< intervals.length;i++){
            if(!isNewIntervalUsed && newInterval[0] <= intervals[i][1]){
                answer.add(new int[]{newInterval[0], newInterval[1]});
                isNewIntervalUsed = true;
            }
            if(answer.size() > 0) {
                int[] prevInterval = answer.get(answer.size()-1);
                if(prevInterval[1] >= intervals[i][0]){
                    int[] newMergedInterval = mergeIntervals(prevInterval, intervals[i]);
                    answer.remove(answer.size()-1);
                    answer.add(newMergedInterval);
                }else{
                    answer.add(intervals[i]);
                }
            }else{
                answer.add(intervals[i]);
            }
        }

        if(!isNewIntervalUsed){
            int[] prevInterval = answer.size() > 0 ? answer.get(answer.size()-1) : new int[]{0,0};
            if(newInterval[0] <= prevInterval[1]){
                int[] newMergedInterval =  mergeIntervals(newInterval, prevInterval);
                answer.remove(answer.size()-1);
                answer.add(newMergedInterval);
            }
            else{
                answer.add(new int[]{newInterval[0], newInterval[1]});
            }
        }

        ansArr = new int[answer.size()][2];
        int i = 0;
        for(int[] interval: answer){
            ansArr[i][0] = interval[0];
            ansArr[i][1] = interval[1];
            i++;
        }
        return ansArr;
    }

    public int[] mergeIntervals(int[] interval1, int[] interval2){

        int mergedIntervalStart = Math.min(interval1[0],  interval2[0]);
        int mergedIntervalEnd = Math.max(interval1[1],  interval2[1]);

        int[] mergedInterval = new int[]{mergedIntervalStart, mergedIntervalEnd};
        return mergedInterval;
    }

    public static void main(String[] args) {
        Insert_New_Intervals_56 m = new Insert_New_Intervals_56();

        int[][] intervals1 = new int[][]{{1,3},{6,9}};
        int[] newInterval1 = new int[]{2,5};
        System.out.println(Arrays.deepToString(m.insert(intervals1, newInterval1))); // lists having equal start and end intervals


        int[][] intervals2 = new int[][]{};
        int[] newInterval2 = new int[]{2,5};
        System.out.println(Arrays.deepToString(m.insert(intervals2, newInterval2))); // lists having equal start and end intervals


        int[][] intervals3 = new int[][]{{1,5}};
        int[] newInterval3 = new int[]{5,7};
        System.out.println(Arrays.deepToString(m.insert(intervals3, newInterval3))); // lists having equal start and end intervals

        int[][] intervals4 = new int[][]{{1,5},{6,9}};
        int[] newInterval4 = new int[]{5,6};
        System.out.println(Arrays.deepToString(m.insert(intervals4, newInterval4))); // lists having equal start and end intervals
    }
}
