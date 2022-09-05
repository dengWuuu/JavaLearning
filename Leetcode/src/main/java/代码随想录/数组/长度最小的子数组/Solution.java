package 代码随想录.数组.长度最小的子数组;

/**
 * @author Wu
 * @date 2022年09月05日 18:55
 */
public class Solution {
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int length = nums.length;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        while (left < length && right < length) {
            sum += nums[right];
            if (sum >= target) {
                while (sum >= target) {
                    if (sum >= target) minLength = Math.min(minLength, right - left + 1);
                    sum -= nums[left++];
                }
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
