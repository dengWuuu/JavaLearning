package 代码随想录.动态规划.一和零;

/**
 * @author Wu
 * @date 2022年09月18日 19:13
 */
public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int one = 0, zero = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') zero++;
                else one++;
            }
            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
