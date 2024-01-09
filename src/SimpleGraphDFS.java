public class SimpleGraphDFS {

    int[][] dirs = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    /*
    Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
     */

    public int isPath(int[][] map) { //is there path between 2 points.
        boolean[][] isVisited = new boolean[map.length][map[0].length];
        int count = 0;
        for (int row = 0 ; row < map.length ; row++) {
            for (int col = 0 ; col < map[0].length ; col++) {
                if (!isVisited[row][col] && map[row][col] == 1){
                    isVisited[row][col] = true;
                    dfs(row,col, map, isVisited);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int i, int j, int[][] map, boolean[][] isVisited){
        //System.out.println(i + ", " + j);
//        if(i == point2[0] && j == point2[1])
//            return true;

        for(int[] dir : dirs){
            int nextR  = i +  dir[0] ;
            int nextC = j + dir[1];
            if (nextR < 0 || nextR >= map.length || nextC >= map[0].length || nextC < 0 || map[nextR][nextC] == 0|| isVisited[nextR][nextC])  {
                continue;
            }
            isVisited[nextR][nextC] = true;
            dfs(nextR, nextC, map, isVisited);
                //return true;

        }

        //return false;
    }


    public static void main(String[] args) {
        SimpleGraphDFS s = new SimpleGraphDFS();

        int[][] grid1 = new int[][]{
                {0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 1, 0}};
        //0,1,2,3,4 --> i
        System.out.println(s.isPath(grid1)); //true
        //System.out.println(s.isPath(new int[]{1,1}, new int[]{2,2}, grid1)); //false
    }
}
