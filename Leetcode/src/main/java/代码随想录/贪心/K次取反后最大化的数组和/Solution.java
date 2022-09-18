package 代码随想录.贪心.K次取反后最大化的数组和;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年09月16日 9:49
 */
public class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int ans = 0, min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int num : nums) {
            min = Math.min(min, Math.abs(num));
            if (num < 0 && k > 0) {
                ans += -num;
                k--;
            } else {
                ans += num;
            }
        }
        return k % 2 == 0 ? ans : ans - 2 * min;
    }
}