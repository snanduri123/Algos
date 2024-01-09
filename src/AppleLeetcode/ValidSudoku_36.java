package AppleLeetcode;
/*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.


Example 1:


Input: board =
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
Example 2:

Input: board =
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.


Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'.
 */


import java.util.HashSet;

public class ValidSudoku_36 {


    //Time: O(r*c) + O(r*c) + O(r*c)
    //Space: O(rows) + O(cols) + O(row*col/3
    public boolean isValidSudoku(char[][] board) {

        //Check every row
        for (int row = 0; row < board.length; row++) {
            HashSet<Character> rowSet = new HashSet<>();
            for (int col = 0; col < board.length; col++) {
                if (board[row][col]!='.' && rowSet.contains(board[row][col]))
                    return false;
                else
                    rowSet.add(board[row][col]);
            }
        }

        //check every col
        for (int col = 0; col < board[0].length; col++) {
            HashSet<Character> colSet = new HashSet<>();
            for (int row = 0; row < board.length; row++) {
                if (board[row][col]!='.' && colSet.contains(board[row][col]))
                    return false;
                else
                    colSet.add(board[row][col]);
            }
        }

        //check every 3*3 cube

        for(int rowStart = 0; rowStart < board.length; rowStart = rowStart+3){
            for(int colStart = 0; colStart < board[rowStart].length; colStart = colStart+3){
                HashSet<Character> cubeSet = new HashSet<>();
                for(int row = rowStart; row < rowStart+ 3; row++){
                    for(int col = colStart; col < colStart+ 3; col++){
                        if(board[row][col]!='.' && cubeSet.contains(board[row][col])){
                            return false;
                        }else{
                            cubeSet.add(board[row][col]);
                        }
                    }
                }
            }
        }return true;
    }

    public static void main(String[] args){
        ValidSudoku_36 v = new ValidSudoku_36();
        System.out.println(v.isValidSudoku(new char[][]{{'5','3','.','.','7','.','.','.','.'},
                                                        {'6','.','.','1','9','5','.','.','.'},
                                                        {'.','9','8','.','.','.','.','6','.'},
                                                        {'8','.','.','.','6','.','.','.','3'},
                                                        {'4','.','.','8','.','3','.','.','1'},
                                                        {'7','.','.','.','2','.','.','.','6'},
                                                        {'.','6','.','.','.','.','2','8','.'},
                                                        {'.','.','.','4','1','9','.','.','5'},
                                                        {'.','.','.','.','8','.','.','7','9'}}));

    }
}
