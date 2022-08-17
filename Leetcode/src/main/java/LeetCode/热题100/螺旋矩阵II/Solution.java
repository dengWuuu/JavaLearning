package LeetCode.热题100.螺旋矩阵II;

/**
 * https://leetcode.cn/problems/spiral-matrix-ii/
 *
 * @author Wu
 * @date 2022年08月16日 11:47
 */
public class Solution {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int nums = 1;
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        while (true) {
            for (int i = left; i <= right; i++) matrix[top][i] = nums++;
            if (++top > bottom) break;
            for (int i = top; i <= bottom; i++) matrix[i][right] = nums++;
            if (--right < left) break;
            for (int i = right; i >= left; i--) matrix[bottom][i] = nums++;
            if (--bottom < top) break;
            for (int i = bottom; i >= top; i--) matrix[i][left] = nums++;
            if (++left > right) break;
        }
        return matrix;
    }
}