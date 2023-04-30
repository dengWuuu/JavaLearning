package LeetCode.周赛总.双周赛.双周赛103.题1;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2023年4月30日 10:21
 */
class Solution {
    public int maximizeSum(int[] nums, int k) {
        Arrays.sort(nums);

        int sum = 0;
        int num = nums[nums.length - 1];
        sum += num;
        for (int i = 1; i < k; i++) {
            num += 1;
            sum += num;
        }
        return sum;
    }
}