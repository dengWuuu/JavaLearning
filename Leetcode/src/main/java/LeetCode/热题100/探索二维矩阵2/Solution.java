package LeetCode.热题100.探索二维矩阵2;

/**
 * @author Wu
 * @date 2022年08月29日 9:43
 */
public class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] > target) col--;
            else if (matrix[row][col] < target) row++;
            else if (matrix[row][col] == target) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(
                searchMatrix(new int[][]{
                        {1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}}, 5));
    }
}
