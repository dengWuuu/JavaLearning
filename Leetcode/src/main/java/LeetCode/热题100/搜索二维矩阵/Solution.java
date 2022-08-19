package LeetCode.热题100.搜索二维矩阵;

/**
 * @author Wu
 * @date 2022年08月18日 11:47
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int row = 0, col = m - 1;
        while (row < n && col >= 0) {
            if (target > matrix[row][col]) row++;
            else if (target == matrix[row][col]) return true;
            else col--;
        }
        return false;
    }
}
