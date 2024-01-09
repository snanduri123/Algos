/*
Given a 2D integer array matrix, return the transpose of matrix.

The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.

2    4  -1             2 -10 18
-10  5  11     --->    4  5  -7
18  -7  6              -1 11  6

(rows becomes columns in transpose matrix)

Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]
Example 2:

Input: matrix = [[1,2,3],[4,5,6]]
Output: [[1,4],[2,5],[3,6]]


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 1000
1 <= m * n <= 105
-109 <= matrix[i][j] <= 109
 */


import java.util.Arrays;

public class TransposeMatrix_867 {
    //Time : O(R * C)
    //Space:  O(R * C)
    public int[][] transpose(int[][] matrix) {
        //rows becomes columns and columns become rows in transpose matrix.
        int[][] ans = new int[matrix[0].length][matrix.length];
        for(int i=0; i< matrix.length; i++){
            for(int j=0; j< matrix[i].length; j++){
                if(i!=j){
                    ans[j][i] = matrix[i][j];
                } else{
                    ans[i][j] = matrix[i][j];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args){
        TransposeMatrix_867 t = new TransposeMatrix_867();
        System.out.println(Arrays.deepToString(t.transpose(new int[][] {{1,2,3 }, {4,5,6}, {7,8,9}})));
        System.out.println(Arrays.deepToString(t.transpose(new int[][] {{1,2,3 }, {4,5,6}})));
    }
}
