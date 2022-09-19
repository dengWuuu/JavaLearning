package 代码随想录.动态规划.零钱兑换II;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年09月19日 9:37
 */
public class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }

    /**
     * 求排列数的方法
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) dp[i] += dp[i - coin];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }
}
