package LeetCode.热题100.买卖股票的最佳时机;

/**
 * https://leetcode.cn/problems/best股票-time-to-buy-and-sell-stock/?favorite=2cktkvj
 * @author Wu
 * @date 2022年08月24日 11:53
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else if (price - min > ans) {
                ans = price - min;
            }
        }
        return ans;
    }
}
