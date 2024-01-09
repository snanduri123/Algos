/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.



Example 1:


Input: matrix = [[1,2,3],
                 [4,5,6],
                 [7,8,9]]
Output:         [[7,4,1],
                 [8,5,2],
                 [9,6,3]]

Example 2:
Input: matrix = [[5,1,9,11],
                 [2,4,8,10],
                 [13,3,6,7],
                 [15,14,12,16]]
Output: [[15,13,2,5],
        [14,3,4,1],
        [12,6,8,9],
        [16,7,10,11]]

 */


import java.util.Arrays;

public class Matrix_RotateImage_48 { //Medium.  input -> transpose (i,j -> j,i) -> reverse row horizontally


    public void rotate(int[][] matrix){
        //Time: O(rows * col)
        //Space: O(1)
        //NOTE: 1 time transpose and 1 time horizontal row reverse makes a matrix rotate by 90 degrees.
        // If you again do transpose and reverse on that rotated matrix then you had rotated original matrix by another 90 degrees (in total 180)

        //1.transpose.
        /*
                 [1,2,3],            [1,4,7],
                 [4,5,6],    -->     [2,5,8],
                 [7,8,9]             [3,6,9]
         */
        for(int i =0; i< matrix.length; i++){
            for(int j = i; j<matrix[0].length;j++){  //** j starts with value of i
                //don't start j with 0 because you will visit again previously swapped cells and will undo that swap
                //Eg: first you will swap (0,1) with (1,0) cell and again when i is incremented,
                // you will end up visiting (1,0) and again swap with (0,1), so the needed change for transpose is gone.
                int temp = matrix[i][j];
                matrix[i][j] =  matrix[j][i];
                matrix[j][i] =  temp;
            }
        }

        //2.reverse horizontally each row
        for(int i = 0; i< matrix.length; i++){
            for(int j = matrix[0].length -1,k=0; j >=k; j--,k++){ //two pointers left and right; left < right
                int temp = matrix[i][k];
                matrix[i][k] =  matrix[i][j];
                matrix[i][j] =  temp;
            }
        }

    }

    public static void main(String[] args){
        Matrix_RotateImage_48 m = new Matrix_RotateImage_48();
        int[][] matrix1 = new int[][]{{1,2,3},{4,5,6},{7,8,9}};  //[7, 4, 1], [8, 5, 2], [9, 6, 3]
        m.rotate(matrix1);
        System.out.println(Arrays.deepToString(matrix1));

//        int[][] matrix2 = new int[][]{{1,2},{4,5},{7,8}};  //invalid test case. matrix should be n * n
//        m.rotate(matrix2);
//        System.out.println(Arrays.deepToString(matrix2));

        int[][] matrix3 = new int[][]{{1}};  //[[1]]
        m.rotate(matrix3);
        System.out.println(Arrays.deepToString(matrix3));
    }
}
