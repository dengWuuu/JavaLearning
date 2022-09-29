package 剑指Offer_专项突击版.数组.乘积小于K的子数组;

/**
 * @author Wu
 * @date 2022年09月27日 17:47
 */
public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length, ans = 0;
        if (k <= 1) return 0;
        for (int i = 0, j = 0, cur = 1; i < n; i++) {
            cur *= nums[i];
            while (cur >= k) cur /= nums[j++];
            ans += i - j + 1;
        }
        return ans;
    }
}