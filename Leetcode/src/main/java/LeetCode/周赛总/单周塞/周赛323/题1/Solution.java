package LeetCode.周赛总.单周塞.周赛323.题1;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
public class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int ans = 0;
        for (int[] ints : grid) {
            Arrays.sort(ints);
        }
        for (int i = grid[0].length - 1; i >= 0; i--) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < grid.length; j++) {
                max = Math.max(max, grid[j][i]);
            }
            ans += max;
        }
        return ans;
    }
}