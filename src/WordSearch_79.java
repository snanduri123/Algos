/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.



Example 1:


Input: board = [['A*','B*','C*','E'],['S','F','C*','S'],['A','D*','E*','E']], word = 'ABCCED'
Output: true
Example 2:


Input: board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 'SEE'
Output: true
Example 3:


Input: board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 'ABCB'
Output: false


Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.


Follow up: Could you use search pruning to make your solution faster with a larger board?
 */

public class WordSearch_79 {

    boolean[][] isVisited;
    int[][] dirs = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (word.length() == 1)
                        return true;
                    if (dpExist(board, i, j, word, 0, new boolean[board.length][board[0].length]))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean dpExist(char[][] board, int i, int j, String word, int charIdx,  boolean[][] isVisited) {
        isVisited[i][j] = true;
        if (board[i][j] == word.charAt(charIdx)) {
            if (charIdx == word.length() - 1) {
                return true;
            }
            for (int[] dir : dirs) {
                if (i + dir[0] >= 0 && j + dir[1] >= 0 && i + dir[0] < board.length && j + dir[1] < board[0].length && !isVisited[i + dir[0]][ j + dir[1]]) {
                    if (dpExist(board, i + dir[0], j + dir[1], word, charIdx + 1, isVisited)) {
                        return true;
                    }
                }
            }
            //return false;
        }
        isVisited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        WordSearch_79 w = new WordSearch_79();
        System.out.println(w.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED")); //true
        System.out.println(w.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE")); //true
        System.out.println(w.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB")); //false
        System.out.println(w.exist(new char[][]{{'a'}}, "a")); //true
        System.out.println(w.exist(new char[][]{{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}}, "AAB")); //true
        System.out.println(w.exist(new char[][]{{'a', 'a'}}, "aa")); //true
        System.out.println(w.exist(new char[][]{{'a', 'b'}, {'c', 'd'}}, "acdb")); //true
    }
}
