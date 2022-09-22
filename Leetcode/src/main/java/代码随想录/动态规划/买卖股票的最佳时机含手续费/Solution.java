package 代码随想录.动态规划.买卖股票的最佳时机含手续费;

/**
 * @author Wu
 * @date 2022年09月20日 22:33
 */
public class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[2][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i % 2][0] = Math.max(dp[(i - 1) % 2][0], dp[(i - 1) % 2][1] - prices[i]);
            dp[i % 2][1] = Math.max(dp[(i - 1) % 2][1], dp[(i - 1) % 2][0] + prices[i] - fee);
        }

        return dp[(prices.length - 1) % 2][1];
    }

    public int maxProfitTan(int[] prices, int fee) {
        int min = prices[0];
        int ans = 0;
        for (int price : prices) {
            int profit = price - min - fee;
            min = Math.min(min, price);
            if (profit > 0) {
                ans += profit;
                min = price - fee;
            }
        }
        return ans;
    }
}
