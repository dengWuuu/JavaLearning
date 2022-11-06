package LeetCode.周赛总.单周塞.周赛310.最长递增子序列II;

/**
 * @author Wu
 * @date 2022年09月11日 11:01
 */
public class Solution {

    public static int lengthOfLIS(int[] nums, int k) {
        if (nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int maxLength = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && nums[i] - nums[j] <= k) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

}
