package 代码随想录.动态规划.最长连续递增子序列;

/**
 * @author Wu
 * @date 2022年09月21日 11:58
 */
public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) dp[i] = dp[i - 1] + 1;
            else dp[i] = 1;
        }
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
