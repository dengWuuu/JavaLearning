package 字节跳动题库.单词搜索;

/**
 * @author Wu
 * @date 2022年11月07日 19:57
 */
public class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int m, n;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != word.charAt(0)) continue;
                if (dfs(board, i, j, word, 1)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, String word, int idx) {
        if (idx == word.length()) return true;
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int nx = i + dir[0], ny = j + dir[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny]) continue;
            if (board[nx][ny] != word.charAt(idx)) continue;
            boolean dfs = dfs(board, nx, ny, word, idx + 1);
            if (dfs) return true;
        }
        visited[i][j] = false;
        return false;
    }
}