/*
Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.

A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.



Example 1:


Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
Output: true
Explanation:
In the above grid, the diagonals are:
"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
In each diagonal all elements are the same, so the answer is True.
Example 2:


Input: matrix = [[1,2],[2,2]]
Output: false
Explanation:
The diagonal "[1, 2]" has different elements.


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 20
0 <= matrix[i][j] <= 99


Follow up:

What if the matrix is stored on disk, and the memory is limited such that you can only load at most one row of the matrix into the memory at once?
What if the matrix is so large that you can only load up a partial row into the memory at once?
 */

public class ToeplitzMatrix_766 {

    int[][] dirs = new int[][]{{-1,-1},{1,1}}; // only needed for DFS style solution which takes extra space.


    //Time: O(rows * cols). Solution: Compare With Top-Left Neighbor
    //Space: O(1)
    //Solution: Compare With Down-right Neighbor
    public boolean isToeplitzMatrix(int[][] matrix) {
        boolean[][] isVisited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(i+1 < matrix.length && j+1 < matrix[0].length) {
                    if(matrix[i][j] != matrix[i+1][j+1])
                        return false;
                }
            }
        }
        return true;
    }

    //Time: O(rows * cols)
    //Space: O(rows * cols) - for isVisited matrix.
    public boolean isToeplitzMatrix2(int[][] matrix) {
        boolean[][] isVisited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(!checkDiagonal(matrix, isVisited, i , j , matrix[i][j]))
                    return false;
            }
        }
        return true;
    }
        public boolean checkDiagonal(int[][] matrix, boolean[][] isVisited, int i, int j , int val){
            if(i < 0 || j < 0 || i > matrix.length -1 || j> matrix[0].length-1 ||  isVisited[i][j]){
                return true;
            }

            isVisited[i][j] = true;
            boolean leftUpDiagonal = false;
            boolean rightDownDiagonal = false;

                if(matrix[i][j] == val) {
                    leftUpDiagonal =  checkDiagonal(matrix, isVisited, i + dirs[0][0], j + dirs[0][1], val);
                    rightDownDiagonal =  checkDiagonal(matrix, isVisited, i + dirs[1][0], j + dirs[1][1], val);
                }


            return leftUpDiagonal && rightDownDiagonal;
        }

        public static void main(String[] args){
        ToeplitzMatrix_766 t = new ToeplitzMatrix_766();
        System.out.println(t.isToeplitzMatrix(new int[][]  {{1,2,3,4},
                                                            {5,1,2,3},
                                                            {9,5,1,2}})); //true

            System.out.println(t.isToeplitzMatrix(new int[][]  {{1,2},
                                                                {2,2}}));  //false

            System.out.println(t.isToeplitzMatrix(new int[][]  {{1,2}}));  // single row. true

            System.out.println(t.isToeplitzMatrix(new int[][]  {{18},{66}})); // single col. true.

            System.out.println(t.isToeplitzMatrix(new int[][]  {{1}})); //true


        }
}
