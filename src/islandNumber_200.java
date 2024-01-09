/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.



Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1


Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
 */
public class islandNumber_200 {

    int[][] dirs = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    //DFS:
    // Time : O(rows * cols)*2  ~ O(n2).
    // Each cell in the grid is visited 2 times
    // (1 time in outer for loop and 1 time in the inner for loop before calling dfs)
    //Space : O(rows * cols)
    public int numIslands(char[][] grid) {
        int count = 0;

        boolean isVisited[][] = new boolean[grid.length][grid[0].length];

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && !isVisited[row][col] && grid[row][col] == '1') {
                    dfs(row, col, grid, isVisited);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int row, int col, char[][] grid, boolean[][] isVisited) {

        if (isVisited[row][col])
            return;

        isVisited[row][col] = true;

        for (int[] dir : dirs) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            if (nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length && !isVisited[nextRow][nextCol] && grid[nextRow][nextCol] == '1') {
                dfs(nextRow, nextCol, grid, isVisited);
            }
        }

    }

    public static void main(String[] args) {
        islandNumber_200 i = new islandNumber_200();

        char[][] grid1 = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        System.out.println(i.numIslands(grid1)); //1

        char[][] grid2 = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println(i.numIslands(grid2)); //3


    }
}
