package 代码随想录.动态规划.最大子序和;

/**
 * @author Wu
 * @date 2022年09月22日 9:15
 */
public class Solution {
    public static int maxSubArray(int[] nums) {
        int dp = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp < 0) {
                dp = nums[i];
            } else dp += nums[i];
            ans = Math.max(ans, dp);
        }
        return ans;
    }
}
