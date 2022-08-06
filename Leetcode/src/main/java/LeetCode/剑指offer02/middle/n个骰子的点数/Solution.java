package LeetCode.剑指offer02.middle.n个骰子的点数;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年08月05日 12:05
 */
public class Solution {
    int dp[][];

    public double[] dicesProbability(int n) {
        dp = new int[n + 1][n * 6 + 1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * n; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j - k <= 0) break;
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }

        int all = (int) Math.pow(6, n);
        double[] ans = new double[6 * n - n + 1];
        for (int i = n; i <= 6 * n; i++) {
            ans[i - n] = (dp[n][i]) * 1.0 / all;
        }
        return ans;
    }
}