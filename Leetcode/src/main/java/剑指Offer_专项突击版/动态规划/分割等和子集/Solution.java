package 剑指Offer_专项突击版.动态规划.分割等和子集;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年10月18日 17:57
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        int size = sum / 2;
        int[] dp = new int[size + 1];

        for (int num : nums) {
            for (int j = size; j >= 1; j--) {
                if (j >= num) {
                    dp[j] = Math.max(dp[j], dp[j - num] + num);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[size] == size;
    }
}
