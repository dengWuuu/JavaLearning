package LeetCode.热题100.被围绕的区域;


/**
 * @author Wu
 * @date 2022年08月24日 13:11
 */
public class Solution {
    static int m, n;

    public static void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }

        for (int i = 0; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'G') board[i][j] = 'O';
            }
        }
    }


    public static void dfs(char[][] board, int i, int j) {
        if (i >= m || i < 0 || j < 0 || j >= n || board[i][j] != 'O') return;
        board[i][j] = 'G';
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }

    public static void main(String[] args) {
        solve(new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'X', 'O'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}});
    }
}
