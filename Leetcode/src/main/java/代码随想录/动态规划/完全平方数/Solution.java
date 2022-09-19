package 代码随想录.动态规划.完全平方数;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年09月19日 18:41
 */
public class Solution {
    public static int numSquares(int n) {
        if (n <= 1) return 1;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 1;
        dp[0] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (dp[i - j * j] != Integer.MAX_VALUE) dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}