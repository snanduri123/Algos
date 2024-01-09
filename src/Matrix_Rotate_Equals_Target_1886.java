/*
Given two n x n binary matrices mat and target, return true if it is possible to make mat equal to target by rotating mat in 90-degree increments, or false otherwise.



Example 1:


Input: mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
Output: true
Explanation: We can rotate mat 90 degrees clockwise to make mat equal target.
Example 2:


Input: mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
Output: false
Explanation: It is impossible to make mat equal to target by rotating mat.
Example 3:


Input: mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
Output: true
Explanation: We can rotate mat 90 degrees clockwise two times to make mat equal target.
 */

import java.util.Arrays;

public class Matrix_Rotate_Equals_Target_1886 {

    public boolean findRotation(int[][] mat, int[][] target) {

        int count = 1;
        //transpose
        for(int i=0; i< mat.length; i++){
            for(int j=i; j< mat[0].length; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        //reverse each row (horizontally)
        for(int i=0; i< mat.length; i++){
            for(int k=0,j=mat[0].length - 1; j > k; j--,k++) {
                int temp = mat[i][k];
                mat[i][k] = mat[i][j];
                mat[i][j] = temp;

                //check if each cell is same as in target
                if(mat[i][k] != target[i][k] || mat[i][j] != target[i][j])
                    return false;
            }
        }
        return true;

    }

    public static void main(String[] args){
        Matrix_Rotate_Equals_Target_1886 m = new Matrix_Rotate_Equals_Target_1886();
        int[][] matrix1 = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] target1 = new int[][]{{7, 4, 1},{8, 5, 2},{9, 6, 3}};
        System.out.println(m.findRotation(matrix1, target1));

    }
}
