package LeetCode.周赛总.单周塞.周赛325.题4;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
class Solution {
    private static final int MOD = (int) 1e9 + 7;

    public int countPartitions(int[] nums, int k) {
        var sum = 0L;
        for (var x : nums) sum += x;
        if (sum < k * 2) return 0;
        var ans = 1;
        var f = new int[k];
        f[0] = 1;
        for (var x : nums) {
            ans = ans * 2 % MOD;
            for (var j = k - 1; j >= x; --j)
                f[j] = (f[j] + f[j - x]) % MOD;
        }
        for (var x : f)
            ans = (ans - x * 2 % MOD + MOD) % MOD; // 保证答案非负
        return ans;
    }
}