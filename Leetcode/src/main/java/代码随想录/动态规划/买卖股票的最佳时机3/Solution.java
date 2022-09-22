package 代码随想录.动态规划.买卖股票的最佳时机3;

/**
 * @author Wu
 * @date 2022年09月20日 18:08
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][5];
        /**
         * 0 没操作
         * 1 第一次买入
         * 2 第一次卖出
         * 3 第二次买入
         * 4 第二次卖出
         */
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[prices.length - 1][4];
    }

    public int maxProfit2(int[] prices) {
        int[][] dp = new int[2][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i % 2][0] = dp[(i - 1) % 2][0];
            dp[i % 2][1] = Math.max(dp[(i - 1) % 2][1], dp[(i - 1) % 2][0] - prices[i]);
            dp[i % 2][2] = Math.max(dp[(i - 1) % 2][2], dp[(i - 1) % 2][1] + prices[i]);
            dp[i % 2][3] = Math.max(dp[(i - 1) % 2][3], dp[(i - 1) % 2][2] - prices[i]);
            dp[i % 2][4] = Math.max(dp[(i - 1) % 2][4], dp[(i - 1) % 2][3] + prices[i]);
        }
        return dp[(prices.length - 1) % 2][4];
    }
}
