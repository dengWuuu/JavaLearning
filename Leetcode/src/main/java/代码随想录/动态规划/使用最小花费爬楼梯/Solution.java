package 代码随想录.动态规划.使用最小花费爬楼梯;

/**
 * @author Wu
 * @date 2022年09月18日 10:15
 */
public class Solution {
    int[] dp;

    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }
}
