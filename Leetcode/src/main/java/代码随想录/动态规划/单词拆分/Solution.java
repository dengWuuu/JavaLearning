package 代码随想录.动态规划.单词拆分;

import java.util.List;

/**
 * @author Wu
 * @date 2022年09月19日 19:03
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    public boolean wordBreakByBackTrack(String s, List<String> wordDict) {
        memory = new int[s.length()];
        return recur(s, wordDict, 0);
    }

    int[] memory;

    public boolean recur(String s, List<String> wordDict, int idx) {
        if (idx == s.length()) return true;
        if (memory[idx] == -1) return false;
        for (int i = idx; i < s.length(); i++) {
            if (wordDict.contains(s.substring(idx, i + 1))) {
                boolean res = recur(s, wordDict, i + 1);
                if (res) return true;
            }
        }
        memory[idx] = -1;
        return false;
    }
}
