package LeetCode.周赛总.单周塞.周赛340.题4;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
class Solution {
    public int minimumVisitedCells(int[][] grid) {
        boolean[][] v;
        Deque<int[]> d = new ArrayDeque<>();
        d.add(new int[]{0, 0});
        v = new boolean[grid.length][grid[0].length];
        v[0][0] = true;
        int ans = 0;
        while (!d.isEmpty()) {
            int size = d.size();
            while (size-- > 0) {
                int[] poll = d.poll();
                assert poll != null;
                int x = poll[0], y = poll[1];
                if (x == grid.length - 1 && y == grid[0].length - 1) return ans + 1;
                for (int i = x; i <= Math.min(grid[x][y] + x, grid.length - 1); i++) {
                    if (v[i][y]) continue;
                    if (i <= grid[x][y] + x) {
                        d.add(new int[]{i, y});
                        v[i][y] = true;
                    }
                }
                for (int i = y; i <= Math.min(grid[x][y] + y, grid[0].length - 1); i++) {
                    if (v[x][i]) continue;
                    if (i <= grid[x][y] + y) {
                        d.add(new int[]{x, i});
                        v[x][i] = true;
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}