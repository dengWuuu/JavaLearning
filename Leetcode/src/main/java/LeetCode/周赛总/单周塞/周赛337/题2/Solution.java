package LeetCode.周赛总.单周塞.周赛337.题2;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
class Solution {

    public static void main(String[] args) {
        System.out.println(checkValidGrid(new int[][]{
                {24, 11, 22, 17, 4},
                {21, 16, 5, 12, 9},
                {6, 23, 10, 3, 18},
                {15, 20, 1, 8, 13},
                {0, 7, 14, 19, 2}}));

    }

    public static boolean checkValidGrid(int[][] grid) {
        int x = 0, y = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        if (grid[0][0] != 0) return false;

        int[][] dirs = new int[][]{{-2, 1}, {-2, -1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        int cur = 0;
        while (cur < m * n) {
            boolean flag = false;
            for (int[] dir : dirs) {
                int nx = dir[0] + x, ny = dir[1] + y;
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (grid[nx][ny] == cur + 1) {
                    x = nx;
                    y = ny;
                    cur++;
                    flag = true;
                    break;
                }
            }
            if (cur == n * n - 1) break;
            if (!flag) {
                return false;
            }
        }
        return true;
    }
}