package LeetCode.热题100.hard.通配符匹配;

/**
 * @author Wu
 * @date 2022年08月14日 13:01
 */
public class Solution {
    static boolean[][] dp;

    public static boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') dp[0][i + 1] = true;
            else break;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) != '*') {
                    if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aab", "c*a*b"));
    }
}
