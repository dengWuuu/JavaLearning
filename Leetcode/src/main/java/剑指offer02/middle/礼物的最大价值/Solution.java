package 剑指offer02.middle.礼物的最大价值;

/**
 * @author Wu
 * @date 2022年08月02日 11:40
 */
public class Solution {
    int[][] dp;

    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m + 1][n + 1];
        dp[0][0] = grid[0][0];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }
}