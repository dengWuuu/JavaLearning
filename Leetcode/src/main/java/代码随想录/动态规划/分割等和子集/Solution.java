package 代码随想录.动态规划.分割等和子集;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年09月18日 15:14
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        int mid = sum / 2;
        int[] dp = new int[mid + 1];
        for (int num : nums) {
            for (int j = mid; j >= num; j--) {
                dp[j] = Math.max(dp[j], dp[j - num] + num);
            }
        }
        return dp[mid] == mid;
    }
}