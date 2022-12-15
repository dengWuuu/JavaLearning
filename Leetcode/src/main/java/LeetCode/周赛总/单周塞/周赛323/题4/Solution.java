package LeetCode.周赛总.单周塞.周赛323.题4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
public class Solution {
    boolean[][] visit;
    Map<Integer, Integer> map = new HashMap<>();
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n;
    public int[] maxPoints(int[][] grid, int[] queries) {
        m = grid.length;
        n = grid[0].length;
        int max = -1;
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, ints[j]);
            }
        }
        int[] ans = new int[queries.length];
        int idx = 0;
        for (int query : queries) {
            if (query > max) {
                ans[idx++] = m * n;
                continue;
            }
            visit = new boolean[m][n];
            ans[idx] = dfs(grid, 0, 0, query);
            idx++;
        }
        return ans;
    }


    public int dfs(int[][] grid, int i, int j, int query) {
        if (query <= grid[i][j]) return 0;
        visit[i][j] = true;
        int sum = 1;

        for (int[] dir : dirs) {
            int nx = i + dir[0], ny = j + dir[1];
            if (nx >= m || nx < 0 || ny >= n || ny < 0 || visit[nx][ny]) continue;
            sum += dfs(grid, nx, ny, query);
        }
        return sum;
    }
}