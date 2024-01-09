public class Islands_number_200 {
    int[][] dirs = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    //DFS:
    // Time : O(rows * cols)
    //Sopace : O(rows * cols)
    public int numIslands(char[][] grid) {

        if (grid.length == 0)
            return 0;
        int islands = 0;
        boolean[][] isVisitedGrid = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != '0' && !isVisitedGrid[i][j]) { // if unVisited 1 (land)
                    dfs(isVisitedGrid, grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    public void dfs(boolean[][] isVisitedGrid, char[][] grid, int row, int col) {

        if (row < 0 || row >= isVisitedGrid.length ||         // check row lower and upper index bound
                col < 0 || col >= isVisitedGrid[0].length ||  // check column lower and upper index bound
                grid[row][col] == '0' ||                    // if it is water then there is no more island
                isVisitedGrid[row][col]) {                    // if the cell with land is already visited then it must have already been calculated as part of an island.
            return;
        }
        isVisitedGrid[row][col] = true;

        for (int[] dir : dirs) {
            dfs(isVisitedGrid, grid, row + dir[0], col + dir[1]);
        }
    }

    public static void main(String[] args) {
        Islands_number_200 i = new Islands_number_200();

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
