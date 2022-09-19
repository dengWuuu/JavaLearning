package 代码随想录.动态规划.打家劫舍2;

/**
 * @author Wu
 * @date 2022年09月19日 20:04
 */
public class Solution {
    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int i = robRange(nums, 0, nums.length - 2);
        int j = robRange(nums, 1, nums.length - 1);
        return Math.max(i, j);
    }

    public static int robRange(int[] nums, int start, int end) {
        if (start == end) return nums[start];
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[end];
    }
}
