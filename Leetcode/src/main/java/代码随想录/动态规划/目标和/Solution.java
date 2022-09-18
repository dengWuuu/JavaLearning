package 代码随想录.动态规划.目标和;

/**
 * @author Wu
 * @date 2022年09月18日 18:48
 */
public class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < Math.abs(target)) return 0;
        int bagSize = (sum + target);
        if (bagSize % 2 != 0) return 0;
        bagSize /= 2;
        if (bagSize < 0) bagSize = -bagSize;
        int[] dp = new int[bagSize + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = bagSize; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[bagSize];
    }
}