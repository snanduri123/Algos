//import java.util.ArrayList;
//import java.util.List;
//
///*
//iven an m x n matrix, return all elements of the matrix in spiral order.
//
//
//
//Example 1:
//
//
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,2,3,6,9,8,7,4,5]
//Example 2:
//
//
//Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]
//
//
//Constraints:
//
//m == matrix.length
//n == matrix[i].length
//1 <= m, n <= 10
//-100 <= matrix[i][j] <= 100
//
// */
//public class SpiralMatrix_54 {
//
//    boolean[][] isVisited;
//    int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
//    public List<Integer> spiralOrder(int[][] matrix) {
//        isVisited = new boolean[matrix.length][matrix[0].length];
//        int[] mid = new int[] {matrix.length/2, matrix[0].length/2};
//        List<Integer> list = new ArrayList<>();
//
//        for(int i=0,j=0; i< matrix.length && i >= 0 && j >=0 && j < matrix[0].length;){
//
//            if(!isVisited[i][j]) {
//                list.add(matrix[i][j]);
//                isVisited[i][j] = true;
//            }
//
//            if(j == matrix[0].length - 1 && i < matrix.length - 1){ // go down when pointer is at the right corner.
//                i++;
//            }
//
//            if(i == matrix.length - 1 && j > 0){
//                j--;
//            }
//
//            if(i == mid[0] && j == mid[1]){
//               break;
//            }
//
//        }
//
//
//    }
//
//}
