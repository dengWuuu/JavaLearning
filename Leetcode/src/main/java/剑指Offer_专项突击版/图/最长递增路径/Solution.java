package 剑指Offer_专项突击版.图.最长递增路径;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    int count = 0;
    int ans = 1;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited;
    int[][] cache;

    public int longestIncreasingPath(int[][] matrix) {
        visited = new boolean[matrix.length][matrix[0].length];
        cache = new int[matrix.length][matrix[0].length];
        ans = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, 1));
            }
        }
        return ans;
    }

    public int dfs(int[][] matrix, int i, int j, int count) {
        if (cache[i][j] != 0) return cache[i][j];


        for (int[] dir : dirs) {
            int nx = dir[0] + i, ny = dir[1] + j;
            if (nx < 0 || nx >= matrix.length || ny < 0 || ny >= matrix[0].length) continue;
            if (matrix[nx][ny] > matrix[i][j]) {
                count = Math.max(count, dfs(matrix, nx, ny, 1) + 1);
            }
        }
        cache[i][j] = count;
        return count;

    }
}