package LeetCode.周赛总.单周塞.周赛324.题2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
public class Solution {
    public static int smallestValue(int n) {
        int ans = Integer.MAX_VALUE;
        while (get(n) != ans) {
            int i = get(n);
            ans = Math.min(ans, i);
            n = i;
        }
        return ans;
    }

    public static int get(int x) {
        int p = 2;
        int ans = 0;
        for (p = 2; p <= x; p++) {
            while (x % p == 0) {
                ans += p;
                if (x == p) return ans;
                x /= p;
            }
        }
        return ans;
    }
}