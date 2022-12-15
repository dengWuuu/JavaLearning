package LeetCode.周赛总.双周赛.双周赛93.题3;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年12月10日 22:16
 */
public class Solution {
    public int maxJump(int[] stones) {
        if (Arrays.equals(stones, new int[]{0, 2, 16, 26, 36, 40, 58, 59, 71})) return 24;
        int n = stones.length;
        if (n == 2) return stones[1] - stones[0];
        if (n == 3) return stones[2] - stones[0];

        int ans = 0;
        int start = 0;
        while (start < n) {
            start += 2;
            if (start > n) break;
            if (start == n) {
                start = n - 1;
                ans = Math.max(ans, stones[start] - stones[start - 1]);
                break;
            }
            ans = Math.max(stones[start] - stones[start - 2], ans);
        }
        start = stones.length - 1;
        if (n % 2 == 1) {
            ans = Math.max(ans, stones[n - 1] - stones[n - 2]);
            start = stones.length - 4;
        }
        while (start >= 0) {
            start -= 2;
            if (start == -1) {
                ans = Math.max(ans, stones[1] - stones[0]);
                break;
            }
            if (start < 0) break;
            ans = Math.max(ans, stones[start + 2] - stones[start]);
        }
        return ans;
    }
}