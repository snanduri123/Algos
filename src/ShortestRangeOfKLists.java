/*
Find shortest range across the given K lists such that atleast one of the elements from each list is in the range.

Time Complexity - O(n * K)
Space Complexity - O(1)

TODO: The better solution is to use min heap - yet to be done
 */

public class ShortestRangeOfKLists {

    public int[] getShortestRange(int[][] lists) {

        int x = 0;
        int y = 0;
        int z = 0;

        int currMin = 0;
        int currMax = 0;
        int currRangeDiff = 0;

        int answerMin = 0;
        int answerMax = 0;
        int answerRangeDiff = Integer.MAX_VALUE;



        while (x < lists[0].length && y < lists[1].length && z < lists[2].length) {

            currMin = Math.min(lists[2][z], Math.min(lists[0][x], lists[1][y]));
            currMax = Math.max(lists[2][z], Math.max(lists[0][x], lists[1][y]));
            currRangeDiff = currMax - currMin;
            if (currRangeDiff < answerRangeDiff) {
                answerRangeDiff = currRangeDiff;
                answerMin = currMin;
                answerMax = currMax;
            }

            if (currMin == lists[0][x]) {
                x++;
            } else if (currMin == lists[1][y]) {
                y++;
            } else if (currMin == lists[2][z]) {
                z++;
            }
        }

        int[] answerRange = {answerMin, answerMax};

        return answerRange;

    }

    public static void main(String[] args){
        int[][] lists = {{4,10,15,24}, {0,9,12,20}, {5,18,22,30}};
        ShortestRangeOfKLists s = new ShortestRangeOfKLists();
        int[] answerRange = s.getShortestRange(lists);
        System.out.println("shortest range min " + answerRange[0]);
        System.out.println("shortest range max " + answerRange[1]);



    }
}
