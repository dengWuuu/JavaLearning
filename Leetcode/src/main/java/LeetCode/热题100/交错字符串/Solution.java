package LeetCode.热题100.交错字符串;

/**
 * @author Wu
 * @date 2022年08月23日 12:38
 */
public class Solution {
    boolean[][] dp;

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), l = s3.length();
        if (m + n != l) return false;
        dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int t3 = i + j - 1;
                if (i > 0) dp[i][j] |= dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(t3);
                if (j > 0) dp[i][j] |= dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(t3);
            }
        }
        return dp[m][n];
    }
}
