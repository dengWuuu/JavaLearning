package LeetCode.周赛总.双周赛.双周赛92.题4;

public class Solution {
    public int countPalindromes(String s) {
        int MOD = (int) (1e9 + 7);
        long ans = 0;
        int n = s.length();
        long[][] pre = new long[n + 1][10];
        long[][][] pre1 = new long[n + 1][10][10];

        for (int i = 1; i <= s.length(); i++) {
            int num = s.charAt(i - 1) - '0';
            System.arraycopy(pre[i - 1], 0, pre[i], 0, 10);
            pre[i][num]++;
            for (int j = 0; j <= 9; j++) {
                System.arraycopy(pre1[i - 1][j], 0, pre1[i][j], 0, 10);
            }
            for (int j = 0; j <= 9; j++) {
                pre1[i][j][num] = (pre1[i][j][num] + pre[i - 1][j]) % MOD;
            }
        }

        long[][] suf = new long[n + 2][10];
        long[][][] suf1 = new long[n + 2][10][10];
        for (int i = n; i > 0; i--) {
            int num = s.charAt(i - 1) - '0';
            System.arraycopy(suf[i + 1], 0, suf[i], 0, 10);
            suf[i][num]++;
            for (int j = 0; j <= 9; j++) {
                System.arraycopy(suf1[i + 1][j], 0, suf1[i][j], 0, 10);
            }
            for (int j = 0; j <= 9; j++) {
                suf1[i][num][j] = (suf1[i][num][j] + suf[i + 1][j]) % MOD;
            }
        }

        //统计答案
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    ans += pre1[i - 1][j][k] * suf1[i + 1][k][j] % MOD;
                }
            }
        }
        return (int) (ans % MOD);
    }
}