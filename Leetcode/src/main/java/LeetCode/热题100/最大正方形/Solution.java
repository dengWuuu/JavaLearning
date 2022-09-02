package LeetCode.热题100.最大正方形;

/**
 * https://leetcode.cn/problems/maximal-square/
 *
 * @author Wu
 * @date 2022年08月28日 15:20
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxLength = 0;
        int m = matrix.length, n = matrix[0].length;
        if (m == 0 || n == 0 || matrix == null) return 0;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) dp[i][j] = 1;
                    else dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
                maxLength = Math.max(dp[i][j], maxLength);
            }
        }
        return maxLength * maxLength;
    }
}
