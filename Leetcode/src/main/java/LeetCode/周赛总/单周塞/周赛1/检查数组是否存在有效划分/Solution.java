package LeetCode.周赛总.单周塞.周赛1.检查数组是否存在有效划分;

/**
 * @author Wu
 * @date 2022年08月07日 11:42
 */
public class Solution {
    static boolean[] dp;

    public static boolean validPartition(int[] nums) {
        int n = nums.length;
        if (n <= 2) return false;
        dp = new boolean[n + 1];
        dp[0] = true;
        dp[1] = false;
        for (int i = 2; i <= n; i++) {
            if (nums[i - 1] == nums[i - 2] && dp[i - 2]) {
                dp[i] = true;
            } else if (i >= 3 && nums[i - 1] - 1 == nums[i - 2] && nums[i - 2] - 1 == nums[i - 3] && dp[i - 3]) {
                dp[i] = true;
            } else if (i >= 3 && nums[i - 1] == nums[i - 2] && nums[i - 2] == nums[i - 3] && dp[i - 3]) {
                dp[i] = true;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(validPartition(new int[]{993335, 993336, 993337, 993338, 993339, 993340, 993341}));
        System.out.println(validPartition(new int[]{4, 4, 4, 5, 6}));
    }
}