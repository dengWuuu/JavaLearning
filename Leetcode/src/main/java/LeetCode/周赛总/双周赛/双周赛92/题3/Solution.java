package LeetCode.周赛总.双周赛.双周赛92.题3;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[][] dp = new int[n][4];
        /**
         * 0 前y
         * 1 前n
         * 2 后y
         * 3 后n
         */
        dp[0][0] = customers.charAt(0) == 'Y' ? 1 : 0;
        dp[0][1] = customers.charAt(0) == 'Y' ? 0 : 1;
        for (int i = 1; i < n; i++) {
            if (customers.charAt(i) == 'Y') {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][1];
            } else {
                dp[i][1] = dp[i - 1][1] + 1;
                dp[i][0] = dp[i - 1][0];
            }
        }
        dp[n - 1][2] = customers.charAt(n - 1) == 'Y' ? 1 : 0;
        dp[n - 1][3] = customers.charAt(n - 1) == 'Y' ? 0 : 1;

        for (int i = n - 2; i >= 0; i--) {
            if (customers.charAt(i) == 'Y') {
                dp[i][2] = dp[i + 1][2] + 1;
                dp[i][3] = dp[i + 1][3];
            } else {
                dp[i][3] = dp[i + 1][3] + 1;
                dp[i][2] = dp[i + 1][2];
            }
        }
        int idx = 0;
        int val = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            int sum = dp[i][2] + ((i - 1 >= 0) ? dp[i - 1][1] : 0);
            if (sum < val) {
                val = sum;
                idx = i;
            }
        }
        if (customers.charAt(n - 1) == 'Y') {
            int sum = dp[n - 1][1];
            if (sum < val) {
                val = sum;
                idx = n;
            }
        }
        return idx;
    }
}