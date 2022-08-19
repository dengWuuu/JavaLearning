package LeetCode.热题100.矩阵置零;

/**
 * @author Wu
 * @date 2022年08月18日 11:11
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean isCol = false, isRow = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                isCol = true;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                isRow = true;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (isCol) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (isRow) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
