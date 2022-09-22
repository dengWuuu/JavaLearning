package 代码随想录.动态规划.最长重复子数组;

/**
 * @author Wu
 * @date 2022年09月21日 20:00
 */
public class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    public int findLength2(int[] nums1, int[] nums2) {
        int[] dp = new int[nums2.length + 1];
        int ans = 0;
        for (int i = 1; i < nums1.length; i++) {
            for (int j = nums2.length; j > 0; j--) {
                if (nums1[i - 1] == nums2[j - 1]) dp[j] = dp[j - 1] + 1;
                else dp[j] = 0;
                ans = Math.max(dp[j], ans);
            }
        }
        return ans;
    }
}
