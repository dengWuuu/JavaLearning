package 代码随想录.动态规划.买卖股票最佳时机含冷冻期;

/**
 * @author Wu
 * @date 2022年09月20日 18:56
 */
public class Solution {
    public int maxProfit(int[] prices) {
        /**
         * 0 没有股票手上(非冷冻期)
         * 1 买入股票
         * 2 昨天卖出股票（冷冻期）
         * 3 今天卖出股票
         */
        int[][] dp = new int[prices.length][4];
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][2] - prices[i], Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]));
            dp[i][2] = dp[i - 1][3];
            dp[i][3] = dp[i - 1][1] + prices[i];
        }
        return Math.max(dp[prices.length - 1][0], Math.max(dp[prices.length - 1][3], dp[prices.length - 1][2]));
    }
}
