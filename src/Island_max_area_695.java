/*
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.



Example 1:


Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0
 */

public class Island_max_area_695 {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0)
            return 0;

        int maxArea = 0;
        boolean[][] isVisitedGrid = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0 && !isVisitedGrid[i][j]) { // if unVisited 1 (land)
                    maxArea = Math.max(maxArea, dfs(isVisitedGrid, grid, i, j));
                }
            }
        }
        return maxArea;
    }

    public int dfs(boolean[][] isVisitedGrid, int[][] grid, int row, int col) {

        if (row < 0 || row >= isVisitedGrid.length ||         // check row lower and upper index bound
                col < 0 || col >= isVisitedGrid[0].length ||  // check column lower and upper index bound
                grid[row][col] == 0   ||                    // if it is water then there is no more island
                isVisitedGrid[row][col]) {                    // if the cell with land is already visited then it must have already been calculated as part of an island.
            return 0;
        }
        isVisitedGrid[row][col] = true;

        int area = 1;  // area of current cell

        area += dfs(isVisitedGrid, grid, row - 1, col);  //up
        area += dfs(isVisitedGrid, grid, row, col - 1); //left
        area += dfs(isVisitedGrid, grid, row + 1, col); //down
        area += dfs(isVisitedGrid, grid, row, col + 1); //right

        return area;
    }
}
