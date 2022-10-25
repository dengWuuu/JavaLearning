package 字节跳动题库.飞书.岛屿数量;

/**
 * @author Wu
 * @date 2022年10月25日 19:17
 */
public class Solution {
    int ans = 0, m, n;

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        for (int[] dir : dirs) {
            int nx = i + dir[0], ny = dir[1] + j;
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == '0') continue;
            dfs(grid, nx, ny);
        }
    }
}