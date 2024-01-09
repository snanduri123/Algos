/*
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.



Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
 */

public class Search_2D {


    //Time : O(log(rows) + log(cols))
    public boolean searchMatrix(int[][] matrix, int target) {

        int start = 0;
        int end = matrix.length-1;

        while(start <= end){
            int mid = (start + end)/2;
            if (target >= matrix[mid][0] && target <= matrix[mid][matrix[mid].length - 1]) {
                return binarySearch( matrix[mid],  target,  0, matrix[mid].length-1);
            }else if(target < matrix[mid][0]){
                end = mid -1;
            }else{
                start = mid+1;
            }
        }
        return false;
    }
    public boolean binarySearch(int[] row, int target, int start, int end) {

        if (start > end) {
            return false;
        }
        int mid = start + (end - start) / 2;

        if (row[mid] == target) {
            return true;
        }

        if (target < row[mid]) {
            return binarySearch(row, target, start, mid - 1);
        } else {
            return binarySearch(row, target, mid + 1, end);
        }
    }
    


    public static void main(String[] args) {
        Search_2D s = new Search_2D();
        System.out.println(s.searchMatrix(new int[][]{{1,3,5,7}, {10,11,16,20},{23,30,34,60}},3));
        System.out.println(s.searchMatrix(new int[][]{{1}}, 1));
        System.out.println(s.searchMatrix(new int[][]{{1,1}}, 2)); //false
    }
}
