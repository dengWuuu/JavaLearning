package LeetCode.周赛总.双周赛.双周赛103.题3;

/**
 * @author Wu
 * @date 2023年4月30日 10:21
 */
class Solution {
    private final static int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int[][] grid;

    public int findMaxFish(int[][] grid) {
        this.grid = grid;
        int m = grid.length, n = grid[0].length, ans = 0;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                ans = Math.max(ans, dfs(i, j));
        return ans;
    }

    private int dfs(int x, int y) {
        int m = grid.length, n = grid[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0)
            return 0;
        int sum = grid[x][y];
        grid[x][y] = 0; // 标记成访问过
        for (var d : DIRS) // 四方向移动
            sum += dfs(x + d[0], y + d[1]);
        return sum;
    }
}
