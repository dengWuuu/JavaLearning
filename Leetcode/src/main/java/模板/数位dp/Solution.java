package 模板.数位dp;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2023年03月20日 9:23
 */
public class Solution {
    char[] s;
    int[][] dp;

    public int countSpecialNumbers(int n) {
        s = String.valueOf(n).toCharArray();
        dp = new int[s.length][1 << 10];
        for (int i = 0; i < s.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, 0, true, false);
    }

    public int f(int i, int mask, boolean limit, boolean isNum) {
        if (i == s.length) return isNum ? 1 : 0;
        if (!limit && isNum && dp[i][mask] != -1) return dp[i][mask];
        int res = 0;
        if (!isNum) res = f(i + 1, mask, false, false);
        int up;
        if (limit) up = s[i] - '0';
        else up = 9;
        for (int j = (isNum ? 0 : 1); j <= up; j++) {
            if ((mask >> j & 1) == 0) {
                res += f(i + 1, mask | (1 << j), (j == up) && limit, true);
            }
        }
        if (!limit && isNum) dp[i][mask] = res;
        return res;
    }
}