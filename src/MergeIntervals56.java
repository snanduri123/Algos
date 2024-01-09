import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals56 {

    //Time: nlogn + n = nlogn
    //Space: O(n)  (additional intermediate space used for arraylist).
    //       If answer is directly returned in arraylist instead of int[][] array then it is O(1).
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> ansList = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);  //sort by starting time.
        int[] prevInterval = intervals[0];  //track prev, so that we can merge current with it (instead of merging curr and next), because there can be more than 2 overlapping intervals
        for (int i = 1; i < intervals.length; i++) {
            if (prevInterval[1] >= intervals[i][0]) {// prevInterval's end >= currInterval's start then merge
                prevInterval[1] = Math.max(prevInterval[1], intervals[i][1]);  //by taking the largest end time.
            } else { // no-overlap
                ansList.add(prevInterval);
                prevInterval = intervals[i];
            }
        }
        ansList.add(prevInterval); //** the last calculated interval (either merged or non-overlapping) should be added.
        int[][] ans = new int[ansList.size()][];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        MergeIntervals56 m = new MergeIntervals56();

        //using arrays method.
        System.out.println(Arrays.deepToString(m.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15,18}}))); //[1,6], [8,10] - end time of one meeting has overlapping with other
//             System.out.println(Arrays.deepToString(m.merge(new int[0][])));  //empty input
//        System.out.println(Arrays.deepToString(m.merge(new int[][]{{1, 4}, {4, 5}}))); // [1,5] - lists having equal start and end intervals
//        System.out.println(Arrays.deepToString(m.merge(new int[][]{{1, 2}, {3, 5}, {4, 5}}))); // [3,5],[4,5] start time of one meeting has overlapping with other
//        System.out.println(Arrays.deepToString(m.merge(new int[][]{{1, 2}, {3, 5}, {4, 6}}))); // [3,5],[4,5] end time of one meeting has some overlapping with other
//        System.out.println(Arrays.deepToString(m.merge(new int[][]{{1, 4}, {5, 6}}))); //[1,4], [5,6]  no overlapping
//        System.out.println(Arrays.deepToString(m.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15,18}}))); //[1,6], [8,10] - end time of one meeting has overlapping with other
//        System.out.println(Arrays.deepToString(m.merge(new int[][]{{1, 4}, {2, 3}}))); //[1,4] second element start and end are smaller than first element end
//        System.out.println(Arrays.deepToString(m.merge(new int[][]{{1, 4}}))); //[1,4] single interval - no overlapping.
    }

}
