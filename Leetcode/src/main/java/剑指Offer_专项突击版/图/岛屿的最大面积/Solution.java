package 剑指Offer_专项突击版.图.岛屿的最大面积;

/**
 * @author Wu
 * @date 2022年10月19日 10:45
 */
public class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int ans = Integer.MIN_VALUE;
    int count = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                count = 0;
                dfs(grid, i, j);
            }
        }
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }

    public void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        if (grid[i][j] == 0) return;

        grid[i][j] = 0;
        count++;
        ans = Math.max(ans, count);
        for (int[] dir : dirs) {
            int nx = i + dir[0], ny = j + dir[1];
            dfs(grid, nx, ny);
        }
    }
}