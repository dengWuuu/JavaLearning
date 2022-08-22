package LeetCode.热题100.解码方法;

/**
 * @author Wu
 * @date 2022年08月22日 12:44
 */
public class Solution {
    static int[] dp;
    public static int numDecodings(String s) {
        int n = s.length();
        dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && (s.charAt(i - 1) - '0') + (s.charAt(i - 2) - '0') * 10 <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
