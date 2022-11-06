package LeetCode.周赛总.单周塞.周赛316.使数组相等的最小开销;

/**
 * @author Wu
 * @date 2022年10月23日 10:51
 */
public class Solution {
    /**
     * 0选择前面
     * 1选择后面
     * 2选择中间前面
     * 3选择中间后面
     */
    public long minCost(int[] nums, int[] cost) {
        long[][] dp = new long[nums.length][4];
        long min = 0;
        for (int i = 1; i < nums.length; i++) {
            int midL = (nums[i] + nums[i - 1]) / 2;
            int midR = (nums[i] + nums[i - 1] + 1) / 2;
            dp[i][0] = min + (long) cost[i - 1] * (Math.abs(nums[i - 1] - nums[i]));
            dp[i][1] = min + (long) cost[i] * (Math.abs(nums[i - 1] - nums[i]));
            dp[i][2] = min + (long) Math.abs(nums[i - 1] - midL) * cost[i - 1] + (long) Math.abs(nums[i] - midL) * cost[i];
            dp[i][3] = min + (long) Math.abs(nums[i - 1] - midR) * cost[i - 1] + (long) Math.abs(nums[i] - midR) * cost[i];
            min = Math.min(dp[i][3], Math.min(dp[i][2], Math.min(dp[i][0], dp[i][1])));
        }
        return min - 1;
    }
}