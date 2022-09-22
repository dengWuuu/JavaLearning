package 代码随想录.动态规划.买卖股票最佳时机5;

/**
 * @author Wu
 * @date 2022年09月20日 18:31
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[2][2 * k + 1];
        for (int i = 0; i <= 2 * k; i++) {
            if (i % 2 != 0) dp[0][i] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= 2 * k; j++) {
                if (j % 2 == 0) dp[i % 2][j] = Math.max(dp[(i - 1) % 2][j], dp[(i - 1) % 2][j - 1] + prices[i]);
                else dp[i % 2][j] = Math.max(dp[(i - 1) % 2][j], dp[(i - 1) % 2][j - 1] - prices[i]);
            }
        }

        return dp[(prices.length - 1) % 2][2 * k];
    }
}
