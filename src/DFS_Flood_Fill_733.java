import java.util.Arrays;

public class DFS_Flood_Fill_733 {

    //               right,  up,   left,     down
    int[][] dirs = {{0,1}, {-1,0}, {0,-1}, {1,0}};

    //Time: O(rows * cols)
    //Space: O(rows * cols) - for isVisited matrix.
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] isVisited = new boolean[image.length][image[0].length];
        int oldColor = image[sr][sc];
        dfs(isVisited, image, oldColor,  color,  sr,  sc);
        return image;
    }


    public void dfs(boolean[][] isVisited, int[][] image, int oldColor, int color, int i, int j){
        if(i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != oldColor || isVisited[i][j]){
            return;
        }


        isVisited[i][j] = true;  //update that this cell is visited, so in future it helps if it is already seen.

        if(image[i][j] == oldColor) {
            image[i][j] = color;

            for(int[] dir : dirs){

                int row = i + dir[0];
                int col = j + dir[1];

                dfs(isVisited, image, oldColor, color, row, col);

            }
        }
    }


    public static void main(String[] args){

        DFS_Flood_Fill_733 d = new DFS_Flood_Fill_733();


        int[][] image1 = new int[][]{{1,1,1},
                                     {1,1,0},
                                     {1,0,1}};
        //starting index is [sr][sc] = image1[1][1].
        // Note the bottom corner will not be colored 2, because it is not 4-directionally connected to the starting pixel.
        System.out.println(Arrays.deepToString(d.floodFill(image1, 1, 1, 2 ))); //     {2,2,2},
                                                                        //      {2,2,0},
                                                                        //      {2,0,1}};

        int[][] image2 = new int[][]{{0,0,0},
                                     {0,0,0},};
        System.out.println(Arrays.deepToString(d.floodFill(image2, 0, 0, 0 ))); //     { {0,0,0},
                                                                        //        {0,0,0}};

    }
}
