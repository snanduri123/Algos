/*
Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.



Example 1:


Input: board = [['X','X','X','X'],['X','O','O','X'],['X','X','O','X'],['X','O','X','X']]
Output: [['X','X','X','X'],['X','X','X','X'],['X','X','X','X'],['X','O','X','X']]
Explanation: Notice that an 'O' should not be flipped if:
- It is on the border, or
- It is adjacent to an 'O' that should not be flipped.
The bottom 'O' is on the border, so it is not flipped.
The other three 'O' form a surrounded region, so they are flipped.
Example 2:

Input: board = [['X']]
Output: [['X']]


Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.
 */

import java.util.Arrays;

public class SurroundedRegions130 {

    int[][] dirs = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public void solve(char[][] board) {
        boolean isVisited[][] = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //for each unvisited border cells with O find all connecting zeroes
                if ((i == 0 || j == board[0].length - 1 || i == board.length - 1 || j == 0) && board[i][j] == 'O' && !isVisited[i][j]) {
                    isVisited[i][j] = true;
                    findZeroDFS(i, j, isVisited, board);
                    //flip 0 to X for the remaining cells whose value is O but are not connected to any border (ie., isVisited is not true)
                }
            }

        }
        for (int m = 0; m < isVisited.length; m++) {
            for (int n = 0; n < isVisited[0].length; n++) {
                if (!isVisited[m][n] && board[m][n] == 'O') {
                    board[m][n] = 'X';
                }
            }
        }
    }

    public void findZeroDFS(int currRow, int currCol, boolean isVisited[][], char[][] board) {

        // Here we know current cell is 0 and we will check if any of its 4-way neighbours is also 0.
        for (int[] dir : dirs) {
            int nextRow = currRow + dir[0];
            int nextCol = currCol + dir[1];
            if (nextRow >= 0 && nextCol >= 0 && nextRow <= board.length - 1 && nextCol <= board[0].length - 1
                    && board[nextRow][nextCol] == 'O'
                    && !isVisited[nextRow][nextCol]) {

                isVisited[nextRow][nextCol] = true;

                findZeroDFS(nextRow, nextCol, isVisited, board);
            }
        }
    }

    public static void main(String[] args) {
        SurroundedRegions130 s = new SurroundedRegions130();

//        //1.
//        char[][] grid1 = new char[][]{
//                {'X', 'X', 'X', 'X'},
//                {'X', 'O', 'O', 'X'},
//                {'X', 'X', 'O', 'X'},
//                {'X', 'O', 'X', 'X'}};
//        //Output::
//        //      {{'X','X','X','X'},
//        //       {'X','X','X','X'},
//        //       {'X','X','X','X'},
//        //       {'X','O','X','X'}};
//        s.solve(grid1);
//        System.out.println(Arrays.deepToString(grid1));
//
//        //2.
//        char[][] grid2 = new char[][]
//                {{'X', 'X', 'X'},
//                        {'X', 'O', 'X'},
//                        {'X', 'X', 'X'}};
//        //Output::
////                {{'X','X','X'},
////                {'X','X','X'},
////                {'X','X','X'}};
//        s.solve(grid2);
//        System.out.println(Arrays.deepToString(grid2));

        //3.
        char[][] grid3 = new char[][]
                {{'X', '0'}, {'O', 'X'}};
        //Output::
//             {{'X', '0'}, {'O', 'X'}};

        s.solve(grid3);
        System.out.println(Arrays.deepToString(grid3));

    }
}
