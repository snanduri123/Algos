/*
Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.



Example 1:

Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 2:

Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 3:

Input: matrix = [[7,8],[1,2]]
Output: [7]
Explanation: 7 is the only lucky number since it is the minimum in its row and the maximum in its column.


Constraints:

m == mat.length
n == mat[i].length
1 <= n, m <= 50
1 <= matrix[i][j] <= 105.
All elements in the matrix are distinct.
 */

import java.util.ArrayList;
import java.util.List;

public class LuckyNumberInMatrix1380 {

    // Time : O(m*n)
    //Space: O(1)
    public List<Integer> luckyNumbers(int[][] matrix) {

        List<Integer> luckyNums = new ArrayList<>();

        for (int[] row : matrix) {
            int colMaxVal = Integer.MIN_VALUE;
            int rowMinVal = Integer.MAX_VALUE;
            int minCol = -1;

            for (int colNo = 0; colNo < row.length; colNo++) {  // for each row, check which col has min value.
                if (row[colNo] < rowMinVal) {
                    rowMinVal = row[colNo];
                    minCol = colNo;
                }
            }

            for (int rowNo = 0; rowNo < matrix.length; rowNo++) { // for min val column, check if the max value in all rows of that col
                if (matrix[rowNo][minCol] > colMaxVal) {
                    colMaxVal = matrix[rowNo][minCol];
                }
            }

            if (rowMinVal == colMaxVal) {  // if minval in the row is same as the maxVal of the column then it is answer.
                luckyNums.add(rowMinVal);
            }
        }
        return luckyNums;
    }

    public static void main(String[] args) {
        LuckyNumberInMatrix1380 l = new LuckyNumberInMatrix1380();
        System.out.println(l.luckyNumbers(new int[][]{{3, 7, 8}, {9, 11, 13}, {15, 16, 17}}));
        System.out.println(l.luckyNumbers(new int[][]{{1,10,4,2}, {9,3,8,7}, {15,16,17,12}}));
    }
}
