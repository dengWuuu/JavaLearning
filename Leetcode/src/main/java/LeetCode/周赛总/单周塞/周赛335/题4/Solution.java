package LeetCode.周赛总.单周塞.周赛335.题4;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
public class Solution {
    private static final int MOD = (int) 1e9 + 7;

    public int waysToReachTarget(int target, int[][] types) {
        var f = new int[target + 1];
        f[0] = 1;
        for (var p : types) {
            int count = p[0], marks = p[1];
            for (int j = target; j > 0; --j)
                for (int k = 1; k <= count && k <= j / marks; ++k)
                    f[j] = (f[j] + f[j - k * marks]) % MOD;
        }
        return f[target];
    }
}
