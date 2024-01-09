public class Islands_closed_islands_1254 {

    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int closedIsland(int[][] grid) {
        if (grid.length == 0)
            return 0;
        int islands = 0;
        boolean[][] isVisitedGrid = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && !isVisitedGrid[i][j] && dfs(isVisitedGrid, grid, i, j)) { // if unVisited 0 (land)
                    islands++;
                }
            }
        }
        return islands;
    }
    public boolean dfs(boolean[][] isVisitedGrid, int[][] grid, int row, int col) {
        if (row == 0 || col == 0 || row == isVisitedGrid.length - 1 || col == isVisitedGrid[0].length - 1) {  //if land cell is on border then it is not surrounded by 1 (water) and hence not become part of closed island.
            return false;
        }
        boolean isPartOfClosedIsland = true;
        isVisitedGrid[row][col] = true;

        for (int[] dir : dirs) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];

            if (grid[nextRow][nextCol] == 0 && !isVisitedGrid[nextRow][nextCol]){        // if 0(land) and not visited then check its neighbours using dfs
                if (!dfs(isVisitedGrid, grid, nextRow, nextCol)) {
                    isPartOfClosedIsland = false;   //if any of the neighbour cells is 0 (land) but is on the border (a failing condition to be closed island) then the current land cell will also not become part of closed island.
                }                                   //mark that it can't be closed island and do not return the call but still continue in loop
                                                        // to check other neighbours so that they can also be tagged with isVisited = true.
            }
        }
        return isPartOfClosedIsland;
    }

    public static void main(String[] args) {
        Islands_closed_islands_1254 i = new Islands_closed_islands_1254();

        int[][] grid1 = new int[][]{
                {0,0,1,0,0},
                {0,1,0,1,0},
                {0,1,1,1,0}};
        System.out.println(i.closedIsland(grid1)); //1

        int[][] grid2 = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}};
        System.out.println(i.closedIsland(grid2)); //2

        int[][] grid3 = new int[][]{
                {0, 0, 1, 1, 0, 1, 0, 0, 1, 0},
                {1, 1, 0, 1, 1, 0, 1, 1, 1, 0},
                {1, 0, 1, 1, 1, 0, 0, 1, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 1, 0}};
        System.out.println(i.closedIsland(grid3)); //5
    }


}
