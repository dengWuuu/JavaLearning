package 剑指Offer_专项突击版.动态规划.爬楼梯的最少成本;

/**
 * @author Wu
 * @date 2022年10月13日 16:03
 */
public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) return 0;
        int[] dp = new int[cost.length + 1];
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], cost[i - 2] + dp[i - 2]);
        }
        return dp[cost.length];
    }

    public int other(int[] cost) {
        if (cost.length == 0) return 0;
        int[] dp = new int[3];
        for (int i = 2; i <= cost.length; i++) {
            dp[i % 3] = Math.min(dp[(i - 1) % 3] + cost[i - 1], dp[(i - 2) % 3] + cost[i - 2]);
        }
        return dp[cost.length % 3];
    }
}