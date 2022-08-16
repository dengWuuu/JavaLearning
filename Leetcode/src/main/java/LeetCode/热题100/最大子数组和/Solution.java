package LeetCode.热题100.最大子数组和;

/**
 * @author Wu
 * @date 2022年08月15日 12:25
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int max = 0;
        for (int i = 1; i < n; i++) {
            nums[i] = Math.max(nums[i], nums[i - 1] + nums[i]);
            max = Math.max(nums[i], max);
        }
        return max;
    }
}
