package LeetCode.热题100.不同路径;

/**
 * https://leetcode.cn/problems/unique-paths/
 *
 * @author Wu
 * @date 2022年08月16日 20:11
 */
public class Solution {
    static int[][] dp;
    public static int uniquePaths(int m, int n) {
        dp = new int[m + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
    public static void main(String[] args) {
        uniquePaths(5,5);
    }
}
