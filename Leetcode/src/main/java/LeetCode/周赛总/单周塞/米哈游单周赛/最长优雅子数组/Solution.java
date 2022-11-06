package LeetCode.周赛总.单周塞.米哈游单周赛.最长优雅子数组;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年09月04日 10:50
 */
public class Solution {
    int[] dp;
    int ans = 1;

    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;
        dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            dp[i] = judge(nums, nums[i], dp[i - 1], i) + 1;
        }

        for (int j : dp) {
            ans = Math.max(j, ans);
        }
        return ans;
    }

    public int judge(int[] nums, int num, int length, int idx) {
        for (int i = idx - 1; i >= idx - length; i--) {
            if ((num & nums[i]) != 0) return idx - i - 1;
        }
        return length;
    }
}