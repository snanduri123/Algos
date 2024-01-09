/*
You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.



Example 1:


Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image above.
Example 2:

Input: grid = [[1]]
Output: 4
Example 3:

Input: grid = [[1,0]]
Output: 4

 */


public class IslandPerimeter_463 {

   //Time complexity -  O(n)
   // Space complexity - 1
    public static void main(String[] args){

        IslandPerimeter_463 i = new IslandPerimeter_463();
        int[][] grid1 = new int[][]{{0,1,0,0},
                                    {1,1,1,0},
                                    {0,1,0,0},
                                    {1,1,0,0}};
        //int[][] grid2 = new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};

        System.out.println(i.islandPerimeter(grid1));
    }

    //Time : O(m*n)
    //Space: O(1)
    public int islandPerimeter1(int[][] grid) {

        int per = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == 1){
                    per = per+4; //perim = perim + 4;
                    if(j!=0 && grid[i][j-1]==1){ //checking if left cell is also island
                        per -= 2; //perim = perim - 2 // subtract 2  because when 2 cells are together then their merging sides 1 each will disappear.
                    }
                    if(i!=0 && grid[i-1][j]==1){ //checking if upper cell is also island
                        per -= 2;  //perim = perim - 2
                    }
                }
            }
        }
        return per;
    }


    public int islandPerimeter(int[][] map){

        int perimeter = 0;
        for(int i=0; i< map.length; i++){
            for(int j=0; j < map[0].length; j++){
                if(map[i][j] == 1) {
                    perimeter = perimeter + 4;

                    if(j!=0 && map[i][j-1] == 1){ //left cell is land
                        perimeter = perimeter - 1;
                    }

                    if(i!=0 && map[i-1][j] == 1){ //top cell is land
                        perimeter = perimeter - 1;
                    }

                    if(j<map[0].length-1 && map[i][j+1] == 1){ //right cell is land
                        perimeter = perimeter - 1;
                    }

                    if(i<map.length-1 && map[i+1][j] == 1){ //bottom cell is land
                        perimeter = perimeter - 1;
                    }
                }

            }
        }
        return perimeter;
    }
}
