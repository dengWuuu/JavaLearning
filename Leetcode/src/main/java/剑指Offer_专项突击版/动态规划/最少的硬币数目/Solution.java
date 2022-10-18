package 剑指Offer_专项突击版.动态规划.最少的硬币数目;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年10月18日 18:35
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                if (dp[j - coin] == Integer.MAX_VALUE) continue;
                else dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}

