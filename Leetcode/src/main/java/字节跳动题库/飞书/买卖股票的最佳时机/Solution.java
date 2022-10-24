package 字节跳动题库.飞书.买卖股票的最佳时机;

/**
 * @author Wu
 * @date 2022年10月24日 20:13
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            ans = Math.max(prices[i] - min, ans);
        }
        return ans;
    }
}
