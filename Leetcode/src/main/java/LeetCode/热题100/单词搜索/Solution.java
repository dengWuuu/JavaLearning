package LeetCode.热题100.单词搜索;

/**
 * @author Wu
 * @date 2022年08月19日 12:49
 */
public class Solution {
    boolean[][] visit;
    int m, n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int idx, int i, int j) {
        if (board[i][j] != word.charAt(idx)) return false;
        else if (idx == word.length() - 1) return true;
        visit[i][j] = true;
        boolean result = false;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] direction : directions) {
            int x = direction[0] + i, y = direction[1] + j;
            if (x >= m || y >= n || x < 0 || y < 0 || visit[x][y]) continue;
            boolean dfs = dfs(board, word, idx + 1, x, y);
            if (dfs) {
                result = true;
                break;
            }
        }
        visit[i][j] = false;
        return result;
    }
}
