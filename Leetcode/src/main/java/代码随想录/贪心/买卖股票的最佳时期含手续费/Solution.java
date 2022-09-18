package 代码随想录.贪心.买卖股票的最佳时期含手续费;

/**
 * @author Wu
 * @date 2022年09月17日 10:15
 */
public class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null) return 0;
        int ans = 0, min = prices[0];
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
