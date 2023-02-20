package LeetCode.周赛总.单周塞.周赛333.题3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
//TODO 补状态压缩dp 和 背包
public class Solution {
    private static final int[] PRIMES = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    private static final int MOD = (int) 1e9 + 7, MX = 30, N_PRIMES = PRIMES.length, M = 1 << N_PRIMES;
    private static final int[] NSQ_TO_MASK = new int[MX + 1]; // NSQ_TO_MASK[i] 为 i 对应的质数集合（用二进制表示）

    static {
        for (int i = 2; i <= MX; ++i)
            for (int j = 0; j < N_PRIMES; ++j) {
                int p = PRIMES[j];
                if (i % p == 0) {
                    if (i % (p * p) == 0) { // 有平方因子
                        NSQ_TO_MASK[i] = -1;
                        break;
                    }
                    NSQ_TO_MASK[i] |= 1 << j; // 把 j 加到集合中
                }
            }
    }
    public int squareFreeSubsets(int[] nums) {
        int[] dp = new int[M];
        dp[0] = 1;
        for (int num : nums) {
            int mask = NSQ_TO_MASK[num];
            if (mask >= 0) {
                for (int i = M - 1; i >= mask; i--) {
                    if ((mask | i) == i) {
                        dp[i] = (dp[i] + (dp[mask ^ i])) % MOD;
                    }
                }
            }
        }
        long ans = 0;
        for (int j : dp) {
            ans += j;
        }
        return (int) ((ans - 1 + MOD) % MOD);

    }
}