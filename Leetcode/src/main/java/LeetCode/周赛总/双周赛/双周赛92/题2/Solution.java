package LeetCode.周赛总.双周赛.双周赛92.题2;

import java.util.Arrays;

class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] diff = new int[m][n];
        int[][] hang = new int[m][2];
        int[][] lie = new int[n][2];
        for (int i = 0; i < m; i++) {
            int sum0 = 0;
            int sum1 = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) sum1++;
                else sum0++;
            }
            hang[i][0] = sum0;
            hang[i][1] = sum1;
        }

        for (int i = 0; i < n; i++) {
            int sum0 = 0;
            int sum1 = 0;
            for (int j = 0; j < m; j++) {
                if (grid[j][i] == 1) sum1++;
                else sum0++;
            }
            lie[i][0] = sum0;
            lie[i][1] = sum1;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diff[i][j] = hang[i][1] + lie[j][1] - hang[i][0] - lie[j][0];
            }
        }
        return diff;

    }
}