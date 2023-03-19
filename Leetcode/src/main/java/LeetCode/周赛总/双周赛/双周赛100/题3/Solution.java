package LeetCode.周赛总.双周赛.双周赛100.题3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年12月10日 22:16
 */
class Solution {

    public int countWays(int[][] ranges) {
        long ans = 0;
        Arrays.sort(ranges, Comparator.comparingInt(x -> x[0]));
        System.out.println(Arrays.deepToString(ranges));

        int[] idx = new int[ranges.length];
        Map<Integer, Integer> map = new HashMap<>();
        int cur = 1;
        idx[0] = cur;
        map.put(1, 1);
        for (int i = 1; i < ranges.length; i++) {
            int x = ranges[i][0];
            if (x <= ranges[i - 1][1]) {
                idx[i] = idx[i - 1];
                ranges[i][1] = Math.max(ranges[i - 1][1], ranges[i][1]);
                map.put(idx[i], map.getOrDefault(idx[i], 0) + 1);
            } else {
                cur += 1;
                idx[i] = cur;
                map.put(idx[i], 1);
            }
        }
        System.out.println(map);
        int cnt = map.size();

        ans = pow3(2, cnt);

        return (int) ans;
    }

    long MOD = (long) (1e9 + 7);

    public long pow3(long a, long b) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = ans * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return ans;
    }
}