package 代码随想录.动态规划.判断子序列;

/**
 * @author Wu
 * @date 2022年09月22日 9:24
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        if (m > n) return false;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[m][n] == m;
    }
}
