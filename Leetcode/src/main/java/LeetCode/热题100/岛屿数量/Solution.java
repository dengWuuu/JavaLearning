package LeetCode.热题100.岛屿数量;

/**
 * @author Wu
 * @date 2022年08月28日 7:48
 */
public class Solution {
    int ans = 0, m, n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }


    public void dfs(char[][] grid, int i, int j) {
        if (i >= m || i < 0 || j >= n || j < 0 || grid[i][j] == '0') return;

        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
