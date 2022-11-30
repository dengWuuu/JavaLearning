package LeetCode.周赛总.双周赛.双周赛91.题2;

import java.util.Arrays;

public class Solution {
    long MOD = (long) (1e9 + 7);


    public int countGoodStrings(int low, int high, int zero, int one) {
        long[] dp = new long[high + 1];
        if (zero == one) dp[zero] = 2;
        else {

            dp[zero] = 1;
            dp[one] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            if (i - zero >= 0) {
                dp[i] += dp[i - zero];
                if (dp[i] >= MOD) dp[i] -= MOD;
            }
            if (i - one >= 0) {
                dp[i] += dp[i - one];
                if (dp[i] >= MOD) dp[i] -= MOD;
            }
        }

        long ans = 0;

        for (int i = low; i <= high; i++) {
            ans += dp[i];
            if (ans >= MOD) ans -= MOD;
        }
        return (int) ans;
    }
}