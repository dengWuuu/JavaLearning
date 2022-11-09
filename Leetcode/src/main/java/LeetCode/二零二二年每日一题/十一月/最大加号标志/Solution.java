package LeetCode.二零二二年每日一题.十一月.最大加号标志;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] grid = new int[n][n];
        for (int[] mine : mines) {
            grid[mine[0]][mine[1]] = 1;
        }
        int[][] left = new int[n][n], right = new int[n][n], up = new int[n][n], down = new int[n][n];
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 0) {
                left[i][0] = 1;
            }
            if (grid[i][n - 1] == 0) {
                right[i][n - 1] = 1;
            }
            if (grid[0][i] == 0) {
                up[0][i] = 1;
            }
            if (grid[n - 1][i] == 0) {
                down[n - 1][i] = 1;
            }
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 0) {
                    left[i][j] = 1 + left[i][j - 1];
                }
                if (grid[i][n - 1 - j] == 0) {
                    right[i][n - 1 - j] = 1 + right[i][n - j];
                }
                if (grid[j][i] == 0) {
                    up[j][i] = 1 + up[j - 1][i];
                }
                if (grid[n - 1 - j][i] == 0) {
                    down[n - 1 - j][i] = 1 + down[n - j][i];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, Math.min(Math.min(left[i][j], right[i][j]), Math.min(up[i][j], down[i][j])));
            }
        }
        return ans;
    }
}