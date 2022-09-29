package 剑指Offer_专项突击版.数组.和大于等于target的最短子数组;

/**
 * @author Wu
 * @date 2022年09月26日 20:02
 */
public class Solution {

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int sum = nums[left], len = Integer.MAX_VALUE;
        while (right < nums.length) {
            if (sum >= target) {
                len = Math.min(len, right - left + 1);
                sum -= nums[left];
                left++;
            } else {
                right++;
                if (right < nums.length) {
                    sum += nums[right];
                }
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}