package 字节跳动题库.飞书.零钱兑换II;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年10月28日 22:09
 */
public class Solution {
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];

        dp[0] = 1;

        //排列数
//        for (int i = 1; i <= amount; i++) {
//            for (int coin : coins) {
//                if (coin <= i) {
//                    dp[i] += dp[i - coin];
//                }
//            }
//        }
//        System.out.println(Arrays.toString(dp));
        //组合数
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(change(5, new int[]{1, 2, 5}));
    }
}