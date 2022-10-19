package 剑指Offer_专项突击版.动态规划.最少回文分割;

import java.util.Arrays;

public class Solution {
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        boolean[][] valid = new boolean[s.length()][s.length()];
        for (int i = 0; i < valid.length; i++) {
            for (int j = 0; j < valid[0].length; j++) {
                valid[i][j] = true;
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                valid[i][j] = s.charAt(i) == s.charAt(j) && valid[i + 1][j - 1];
            }
        }
        System.out.println(Arrays.deepToString(valid));
        Arrays.fill(dp,Integer.MAX_VALUE);

        for (int i = 0; i < s.length(); i++) {
            if (valid[0][i]) dp[i] = 0;
            else {
                for (int j = 0; j < i; j++) {
                    if (valid[j + 1][i]) {
                        dp[i] = Math.min(dp[i], dp[i - j] + 1);
                    }
                }
            }
        }
        return dp[dp.length - 1];
    }
}