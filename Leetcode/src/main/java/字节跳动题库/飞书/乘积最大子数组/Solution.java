package 字节跳动题库.飞书.乘积最大子数组;

/**
 * @author Wu
 * @date 2022年10月27日 15:03
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                dp[i][0] = Math.max(dp[i - 1][0] * nums[i], nums[i]);
                dp[i][1] = dp[i - 1][1] * nums[i];
            } else {
                dp[i][0] = Math.max(nums[i], dp[i - 1][1] * nums[i]);
                dp[i][1] = Math.min(nums[i], dp[i - 1][0] * nums[i]);
            }
            max = Math.max(max, dp[i][0]);
        }

        return max;
    }
}
