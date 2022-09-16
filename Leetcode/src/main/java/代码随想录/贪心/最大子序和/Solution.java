package 代码随想录.贪心.最大子序和;

/**
 * @author Wu
 * @date 2022年09月15日 19:16
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 0) return 0;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 1] + nums[i], nums[i]);
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}