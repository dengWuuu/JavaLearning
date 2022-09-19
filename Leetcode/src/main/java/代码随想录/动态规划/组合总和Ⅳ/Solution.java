package 代码随想录.动态规划.组合总和Ⅳ;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年09月19日 9:58
 */
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }

    /**
     * 回溯暴搜
     *
     * @param nums
     * @param target
     */
    int ans = 0;
    Map<Integer, Integer> cache = new HashMap<>();

    public void backTrack(int[] nums, int target) {
        if (target == 0) ans++;
    }
}
