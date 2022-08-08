package LeetCode.热题100.最长回文子串;

/**
 * @author Wu
 * @date 2022年08月07日 11:12
 */
public class Solution {
    boolean[][] dp;

    public String longestPalindrome(String s) {
        int n = s.length();
        dp = new boolean[n + 1][n + 1];
        if (n < 2) return s;
        int begin = 0, maxLen = 1;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}