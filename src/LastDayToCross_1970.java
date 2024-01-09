/*
There is a 1-based binary matrix where 0 represents land and 1 represents water. You are given integers row and col representing the number of rows and columns in the matrix, respectively.

Initially on day 0, the entire matrix is land. However, each day a new cell becomes flooded with water. You are given a 1-based 2D array cells, where cells[i] = [ri, ci] represents that on the ith day, the cell on the rith row and cith column (1-based coordinates) will be covered with water (i.e., changed to 1).

You want to find the last day that it is possible to walk from the top to the bottom by only walking on land cells. You can start from any cell in the top row and end at any cell in the bottom row. You can only travel in the four cardinal directions (left, right, up, and down).

Return the last day where it is possible to walk from the top to the bottom by only walking on land cells.



Example 1:


Input: row = 2, col = 2, cells = [[1,1],[2,1],[1,2],[2,2]]
Output: 2
Explanation: The above image depicts how the matrix changes each day starting from day 0.
The last day where it is possible to cross from top to bottom is on day 2.
Example 2:


Input: row = 2, col = 2, cells = [[1,1],[1,2],[2,1],[2,2]]
Output: 1
Explanation: The above image depicts how the matrix changes each day starting from day 0.
The last day where it is possible to cross from top to bottom is on day 1.
Example 3:


Input: row = 3, col = 3, cells = [[1,2],[2,1],[3,3],[2,2],[1,1],[1,3],[2,3],[3,2],[3,1]]
Output: 3
Explanation: The above image depicts how the matrix changes each day starting from day 0.
The last day where it is possible to cross from top to bottom is on day 3.


Constraints:

2 <= row, col <= 2 * 104
4 <= row * col <= 2 * 104
cells.length == row * col
1 <= ri <= row
1 <= ci <= col
All the values of cells are unique.
 */

import java.util.Arrays;

public class LastDayToCross_1970 {
    int dirs[][] = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int latestDayToCross(int row, int col, int[][] cells) {

        int day = 0;
        int start = 0;
        int end = cells.length - 1;

        while (start <= end) { //p1
            int mid = start + (end - start) / 2;

            boolean isVisited[][] = new boolean[row][col];

            int[][] matrix = new int[row][col];
            for (int i = 0; i <= mid; i++) {
                matrix[cells[i][0] - 1][cells[i][1] - 1] = 1;
            }
            //Arrays.fill(isVisited, false);

            boolean canCross = false;

            for (int currCol = 0; currCol < matrix[0].length; currCol++) {
                if (matrix[0][currCol] == 1 || isVisited[0][currCol]) {
                    continue;
                }
                if (canCrossTopToBottom(matrix, 0, currCol, isVisited)) {
                    canCross = true;
                    break;
                }
            }

            if (canCross) {
                day = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return day + 1;

    }
    public boolean canCrossTopToBottom(int[][] matrix, int row, int col, boolean isVisited[][]) {

        if (row == matrix.length - 1)
            return true;

        isVisited[row][col] = true;

        for (int[] dir : dirs) {
            if (row + dir[0] >= 0 && row + dir[0] <= matrix.length - 1 &&
                    col + dir[1] >= 0 && col + dir[1] <= matrix[0].length - 1 &&
                    matrix[row + dir[0]][col + dir[1]] == 0 && !isVisited[row + dir[0]][col + dir[1]]) {
                if (canCrossTopToBottom(matrix, row + dir[0], col + dir[1], isVisited))
                    return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        LastDayToCross_1970 l = new LastDayToCross_1970();
        System.out.println(l.latestDayToCross(2, 2, new int[][]{{1, 1}, {1, 2}, {2, 1}, {2, 2}})); // 1
        System.out.println(l.latestDayToCross(2, 2, new int[][]{{1, 1}, {2, 1}, {1, 2}, {2, 2}})); // 2
        System.out.println(l.latestDayToCross(3, 3, new int[][]{{1, 2}, {2, 1}, {3, 3}, {2, 2}, {1, 1}, {1, 3}, {2, 3}, {3, 2}, {3, 1}})); //3
    }
}
