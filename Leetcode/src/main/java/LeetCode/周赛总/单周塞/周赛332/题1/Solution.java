package LeetCode.周赛总.单周塞.周赛332.题1;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
public class Solution {
    public long findTheArrayConcVal(int[] nums) {
        int l = 0, r = nums.length - 1;
        long ans = 0;
        while (l < r) {
            String ln = String.valueOf(nums[l++]);
            String rn = String.valueOf(nums[r--]);
            long aLong = Long.parseLong(ln + rn);
            ans += aLong;
        }
        if (l == r) ans += nums[l];
        return ans;

    }
}