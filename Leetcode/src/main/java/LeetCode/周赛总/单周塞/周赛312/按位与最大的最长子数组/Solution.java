package LeetCode.周赛总.单周塞.周赛312.按位与最大的最长子数组;

/**
 * @author Wu
 * @date 2022年09月25日 10:34
 */
public class Solution {
    public static int longestSubarray(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] dp = new int[nums.length];
        int ans = 1;
        dp[0] = nums[0] >= max ? 1 : 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= max) dp[i] = 1;
            else dp[i] = 0;

            if (nums[i] >= nums[i - 1] && dp[i - 1] >= 1) {
                dp[i] = dp[i - 1] + 1;
            }
            ans = Math.max(ans, dp[i]);

        }
        return ans;

    }
}
//[100,5,5]
