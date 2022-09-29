package 剑指offer02.easy.连续子数组的最大和;

/**
 * @author Wu
 * @date 2022年07月31日 13:02
 */
public class Solution {
    int[] dp;

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        dp[0] = nums[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public int solution(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            ans = Math.max(nums[i], ans);
        }
        return ans;
    }
}