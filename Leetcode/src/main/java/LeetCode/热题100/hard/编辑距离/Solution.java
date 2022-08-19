package LeetCode.热题100.hard.编辑距离;

/**
 * @author Wu
 * @date 2022年08月18日 10:41
 */
public class Solution {
    int[][] dp;

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        dp = new int[m + 1][n + 1];
        if (m * n == 0) return m + n;
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1));
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
