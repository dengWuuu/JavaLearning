package 代码随想录.动态规划.最长公共子序列;

/**
 * @author Wu
 * @date 2022年09月21日 21:37
 */
public class Solution {
    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);

            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static int longestCommonSubsequence2(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        int[] dp = new int[n2 + 1];

        for (int i = 1; i <= n1; i++) {

            // 这里pre相当于 dp[i - 1][j - 1]
            int pre = dp[0];
            for (int j = 1; j <= n2; j++) {

                //用于给pre赋值
                int cur = dp[j];
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    //这里pre相当于dp[i - 1][j - 1]   千万不能用dp[j - 1] !!
                    dp[j] = pre + 1;
                } else {
                    // dp[j]     相当于   dp[i - 1][j]
                    // dp[j - 1] 相当于   dp[i][j - 1]
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                //更新dp[i - 1][j - 1], 为下次使用做准备
                pre = cur;
            }
        }

        return dp[n2];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }
}
