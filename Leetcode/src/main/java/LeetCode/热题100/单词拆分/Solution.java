package LeetCode.热题100.单词拆分;

import java.util.List;

/**
 * @author Wu
 * @date 2022年08月27日 14:54
 */
public class Solution {
    static boolean[] dp;

    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        if (n == 0) return true;
        dp = new boolean[n + 1];
        dp[0] = true;
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < wordDict.size(); i++) {
            maxLen = Math.max(wordDict.get(i).length(), maxLen);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = Math.max(0, i - maxLen); j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
