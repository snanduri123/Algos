/*
Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.



Example 1:

'1','0','1', '0', '0'
'1','0','1'*,'1'*,'1'*     --> actually there are two 2 * 2 squares but we consider 1 square and area will be 4.
'1','1','1'*,'1'*,'1'*
'1','0','0', '1', '0'

Input: matrix = [['1','0','1','0','0'},['1','0','1','1','1'],['1','1','1','1','1'],['1','0','0','1','0']]
Output: 4
Example 2:


Input: matrix = [['0','1'],['1','0']]
Output: 1  //two valid squares of size 1 * 1. so area will be 1.




Example 3:

Input: matrix = [['0']]
Output: 0


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 300
matrix[i][j] is '0' or '1'.
 */

//Solution:

import java.util.Arrays;

public class MaximalSquare_221 {

    //Time complexity : O(mn). Single pass - row x col (m=row; n=col)
    //Space complexity : O(mn).
    public int maximalSquare(char[][] matrix) {

        int maxSide = 0;
        int [][] dp = new int[matrix.length][matrix[0].length];

        //Arrays.fill(dp, matrix);

        //if there is any cell with value 1 in first row then the maximal square that you can find is of area 1. (Even if there are multiple cells with 1 their area is still 1)
        for(int row =0; row < matrix.length; row++){
            dp[row][0] =  matrix[row][0] - '0';
            maxSide = Math.max(maxSide, dp[row][0]);
        }

        //if there is any cell with value 1 in first col then the maximal square that you can find is of area 1. (Even if there are multiple cells with 1 their area is still 1)
        for(int col =0; col < matrix[0].length; col++){
            dp[0][col] =  matrix[0][col] - '0';
            maxSide = Math.max(maxSide, dp[0][col]);
        }

        // 1 1 1               1 1 1
        // 1 1 1       --->    1 2 2
        // 1 1 1               1 2 3

        //starting from [1,1] position, for every cell, check  the left, upper left and top - 3 cells and update the current cell value with the maximum area it can form based on those 3 cells
        for(int row=1; row< matrix.length; row++){
            for(int col =1; col < matrix[0].length; col++){
                if( matrix[row][col] == '1') {
                    dp[row][col] = Math.min(Math.min(dp[row - 1][col], dp[row][col - 1]), dp[row - 1][col - 1]) + 1;
                    maxSide = Math.max(maxSide, dp[row][col]);
                }
            }
        }

        return maxSide * maxSide ;
    }

    public static void main(String[] args){
        MaximalSquare_221 m = new MaximalSquare_221();

        char[][] matrix1 = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(m.maximalSquare(matrix1)); //4
    }

}
