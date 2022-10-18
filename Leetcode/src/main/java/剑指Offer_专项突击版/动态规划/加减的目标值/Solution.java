package 剑指Offer_专项突击版.动态规划.加减的目标值;

/**
 * @author Wu
 * @date 2022年10月18日 18:22
 */
public class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + target) % 2 != 0) return 0;
        int size = (sum + target) / 2;
        int[] dp = new int[size + 1];

        for (int num : nums) {
            for (int j = size; j >= 0; j--) {
                if (j > num) {
                    dp[j] += dp[j - num] + 1;
                }
            }
        }

        return dp[size];

    }
}