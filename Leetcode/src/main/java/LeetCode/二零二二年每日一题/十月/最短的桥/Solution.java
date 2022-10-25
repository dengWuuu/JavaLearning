package LeetCode.二零二二年每日一题.十月.最短的桥;

import java.util.*;

/**
 * @author Wu
 * @date 2022年10月25日 13:02
 */
public class Solution {
    int m, n;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};


    public int shortestBridge(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, queue);
                    int size = queue.size();
                    for (int k = 0; k < size; k++) {
                        int[] poll = queue.poll();
                        for (int[] dir : dirs) {
                            assert poll != null;
                            int nx = dir[0] + poll[0], ny = dir[1] + poll[1];
                            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                            queue.add(new int[]{nx, ny});
                        }
                    }
                    int step = 0;
                    while (!queue.isEmpty()) {
                        int num = queue.size();
                        for (int k = 0; k < num; k++) {
                            int[] poll = queue.poll();
                            for (int[] dir : dirs) {
                                int nx = poll[0] + dir[0], ny = dir[1] + poll[1];
                                if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == 2) continue;
                                if (grid[nx][ny] == 1) return step;
                                queue.add(new int[]{nx, ny});
                            }
                        }
                        step++;
                    }
                }
            }
        }
        return -1;
    }


    public void dfs(int[][] grid, int i, int j, Queue<int[]> queue) {
        if (grid[i][j] ==1) grid[i][j] = 2;
        queue.add(new int[]{i, j});
        for (int[] dir : dirs) {
            int nx = i + dir[0], ny = j + dir[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == 2 || grid[nx][ny] == 0) continue;
            dfs(grid, nx, ny, queue);
        }
    }
}
