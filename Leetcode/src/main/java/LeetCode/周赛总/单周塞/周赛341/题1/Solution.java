package LeetCode.周赛总.单周塞.周赛341.题1;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int maxLen = 0;
        int idx = 0;
        for (int i = 0; i < mat.length; i++) {
            int nums = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    nums++;
                }
            }
            if (nums > maxLen) {
                maxLen = nums;
                idx = i;
            }
        }
        return new int[]{idx, maxLen};
    }
}