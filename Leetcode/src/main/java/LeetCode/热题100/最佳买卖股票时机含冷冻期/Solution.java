package LeetCode.热题100.最佳买卖股票时机含冷冻期;

/**
 * @author Wu
 * @date 2022年08月30日 22:21
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        dp[0][1] = dp[0][2] = 0;
        /**
         * 1 今天持有股票
         * 2 今天没股票 且在冷冻期
         * 3 今天没股票 且不再冷冻期
         */
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }
}
