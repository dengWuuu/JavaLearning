package LeetCode.周赛总.双周赛.双周赛89.最小化数组中的最大值;

/**
 * @author Wu
 * @date 2022年10月15日 23:12
 */
public class Solution {
    public int minimizeArrayValue(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.min(nums[i], dp[i - 1]);
        }
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        //获取到最大值
        int little = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] == max) {
//                while (i > 0 && nums[i] > 0 && nums[i - 1] < nums[i]) {
//                    nums[i]--;
//                    nums[i - 1]++;
//                }
//                little = Math.min(little, nums[i]);
//            } else {
//                while (i > 0 && nums[i - 1] < max) {
//                    nums[i]--;
//                    nums[i - 1]++;
//                }
//            }
            if (nums[i] == max) {
                little = Math.min(little, (max + dp[i - 1]) / 2);
            }
        }
        return little;
    }
}