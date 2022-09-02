package LeetCode.热题100.分割等和子集;

/**
 * @author Wu
 * @date 2022年09月01日 8:46
 */
public class Solution {
    int[] dp;

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;

        dp = new int[10001];

        int target = sum / 2;
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = Math.max(dp[j], dp[j - num] + num);
            }
        }

        return dp[target] == target;

    }
}
