package 剑指Offer_专项突击版.动态规划.排列的数目;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年10月18日 19:19
 */
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
