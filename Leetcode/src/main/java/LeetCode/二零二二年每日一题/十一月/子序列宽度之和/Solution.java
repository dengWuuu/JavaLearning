package LeetCode.二零二二年每日一题.十一月.子序列宽度之和;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年11月18日 9:58
 */
public class Solution {
    static int N = 100000;
    static int MOD = (int) (1e9 + 7);
    static long[] p = new long[N];

    static {
        p[0] = 1;
        for (int i = 1; i < N; i++) p[i] = p[i - 1] * 2 % MOD;
    }

    public int sumSubseqWidths(int[] nums) {
        long ans = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            ans += (p[i] * nums[i]) % MOD;
            ans %= MOD;
            ans -= (p[n - i - 1] * nums[i]) % MOD;
            ans %= MOD;
        }
        return (int) ans;
    }

    public int sumSubseqWidths2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long ans = 0, pow = 1;
        for (int i = 0; i < nums.length; i++) {
            ans = (ans + pow * (nums[i] - nums[n - 1 - i])) % MOD;
            pow = pow * 2 % MOD;
        }
        return (int) ans;
    }
}