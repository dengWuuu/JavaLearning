package LeetCode.热题100.目标和;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年09月02日 9:13
 */
public class Solution {
    int ans = 0;
    Map<String, Integer> cache = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) return 0;
        int bagLength = diff / 2;
        int[] dp = new int[bagLength + 1];
        dp[0] = 1;
         for (int num : nums) {
            for (int j = bagLength; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[bagLength];
    }


    /**
     * 回溯+记忆化递归
     *
     * @param nums
     * @param target
     * @param idx    下标
     * @param sum    求和
     * @return
     */
    public int backTrack(int[] nums, int target, int idx, int sum) {
        String key = idx + "_" + sum;
        if (cache.containsKey(key)) return cache.get(key);
        if (idx == nums.length) {
            cache.put(key, sum == target ? 1 : 0);
            return cache.get(key);
        }
        int left = backTrack(nums, target, idx + 1, sum + nums[idx]);
        int right = backTrack(nums, target, idx + 1, sum - nums[idx]);
        cache.put(key, left + right);
        return cache.get(key);
    }
}
