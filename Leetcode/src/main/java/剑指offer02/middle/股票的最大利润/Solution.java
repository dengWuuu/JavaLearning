package 剑指offer02.middle.股票的最大利润;

/**
 * @author Wu
 * @date 2022年08月05日 16:37
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}
