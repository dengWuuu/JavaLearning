package LeetCode.二零二二年每日一题.八月.逐步求和得到正数的最小值;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年08月09日 21:02
 */
public class Solution {
    public int minStartValue(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0, j = 1; i < n; i++) {
            j += nums[i];
            min = Math.min(j, min);
        }
        return min < 1 ? 2 - min : 1;
    }
}