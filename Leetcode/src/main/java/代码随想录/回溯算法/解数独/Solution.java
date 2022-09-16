package 代码随想录.回溯算法.解数独;

/**
 * @author Wu
 * @date 2022年09月14日 21:22
 */
public class Solution {
    int n, m;

    public void solveSudoku(char[][] board) {
        n = board.length;
        m = board[0].length;
        backTrack(board);
    }

    boolean backTrack(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') continue;
                for (char k = '1'; k <= '9'; k++) {
                    if (isValid(board, i, j, k)) {
                        board[i][j] = k;
                        if (backTrack(board)) return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }


    public boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
            if (board[row][i] == num) return false;
        }
        //判断9宫格内是否有重复的
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
