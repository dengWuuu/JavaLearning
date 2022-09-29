package 剑指offer02.middle.矩阵中的路径;

/**
 * @author Wu
 * @date 2022年08月01日 11:53
 */
public class Solution {
    boolean[][] visited;
    int ans, m, n;
    char[] chars;

    public boolean exist(char[][] board, String word) {
        ans = word.length() - 1;
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        chars = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, int k) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] != chars[k]) {
            return false;
        }
        if (k == ans) {
            return true;
        }
        visited[i][j] = true;
        boolean res = dfs(board, i + 1, j, k + 1) || dfs(board, i - 1, j, k + 1)
                || dfs(board, i, j + 1, k + 1) || dfs(board, i, j - 1, k + 1);
        visited[i][j] = false;
        return res;
    }
}