package 剑指Offer_专项突击版.动态规划.子序列的数目;

/**
 * @author Wu
 * @date 2022年10月17日 17:41
 */
public class Solution {
    /**
     * @param s
     * @param t
     * @return
     */
    public static int numDistinct(String s, String t) {
        if (s.length() < t.length()) return 0;
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                dp[i][j] = dp[i - 1][j] + (s.charAt(i - 1) == t.charAt(j - 1) ? dp[i - 1][j - 1] : 0);
            }
        }

        return dp[s.length()][t.length()];
    }

    public static int num(String s, String t) {
        if (s.length() < t.length()) return 0;
        int[] dp = new int[t.length() + 1];

        dp[0] = 1;

        for (int i = 1; i < s.length(); i++) {
            for (int j = t.length(); j >= 1; j--) {
                dp[j] += (s.charAt(i - 1) == t.charAt(j - 1) ? dp[j - 1] : 0);
            }
        }
        return dp[t.length()];
    }
}
