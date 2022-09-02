package LeetCode.热题100.最长递增子序列;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年08月30日 20:03
 */
public class Solution {
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        dp[0] = 1;
        int length = nums.length;
        int maxLength = 0;
        for (int i = 1; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maxLength = Math.max(dp[i], maxLength);
        }
        return maxLength;
    }
}
