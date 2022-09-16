package 代码随想录.贪心.买卖股票的最佳时机II;

/**
 * @author Wu
 * @date 2022年09月15日 19:32
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(prices[i] - prices[i - 1], 0);
        }
        return ans;
    }
}
