package LeetCode.热题100.除自身以外数组的乘积;

/**
 * @author Wu
 * @date 2022年08月29日 9:06
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int p = 1, q = 1;
        for (int i = 0; i < nums.length; i++) {
            ans[i] = p;
            p *= nums[i];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            q *= nums[i + 1];
            ans[i] *= q;
        }
        return ans;
    }
}
