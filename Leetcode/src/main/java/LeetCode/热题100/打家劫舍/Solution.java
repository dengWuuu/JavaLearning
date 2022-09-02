package LeetCode.热题100.打家劫舍;

/**
 * @author Wu
 * @date 2022年08月27日 20:34
 */
public class Solution {
    int[] dp;

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[n - 1];
    }

    public int robWithOut(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int p = nums[0], q = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int tmp = q;
            q = Math.max(p + nums[i], q);
            p = tmp;
        }
        return q;
    }
}
