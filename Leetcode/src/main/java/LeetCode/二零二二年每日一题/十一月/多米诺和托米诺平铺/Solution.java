package LeetCode.二零二二年每日一题.十一月.多米诺和托米诺平铺;

public class Solution {
    private static final long MOD = (long) 1e9 + 7;

    public int numTilings(int n) {
        if (n == 1) return 1;
        long[] f = new long[n + 1];
        f[0] = f[1] = 1;
        f[2] = 2;
        for (int i = 3; i <= n; ++i)
            f[i] = (f[i - 1] * 2 + f[i - 3]) % MOD;
        return (int) f[n];
    }
}
