package LeetCode.周赛总.单周塞.周赛334.题4;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
public class Solution {
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;
        int m = grid.length, n = grid[0].length;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        int[][] dis = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dis[i][j] = Integer.MAX_VALUE;
            }
        }
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        dis[0][0] = 0;
        priorityQueue.add(new int[]{0, 0, 0});
        while (!priorityQueue.isEmpty()) {
            int[] poll = priorityQueue.poll();
            if (poll[1] == m - 1 && poll[2] == n - 1) return poll[0];
            for (int[] dir : dirs) {
                int nx = poll[1] + dir[0], ny = poll[2] + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                int nd = Math.max(poll[0] + 1, grid[nx][ny]);
                nd += (nd - nx - ny) % 2;
                if (nd < dis[nx][ny]) {
                    dis[nx][ny] = nd;
                    priorityQueue.add(new int[]{nd, nx, ny});
                }
            }
        }
        return dis[m - 1][n - 1];
    }
}