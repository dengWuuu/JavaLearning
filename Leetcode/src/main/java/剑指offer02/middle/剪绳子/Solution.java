package 剑指offer02.middle.剪绳子;

/**
 * @author Wu
 * @date 2022年07月25日 12:19
 */
public class Solution {
    int[] dp;

    public int cuttingRope(int n) {
        dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i < n; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
            }
        }
        return dp[n];
    }
}
