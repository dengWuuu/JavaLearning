package 剑指offer02.middle.二维数组的查找04_middle;

/**
 * @author Wu
 * @date 2022年07月20日 16:51
 */
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int start = 0;
        while (start <= n && m >= 0) {
            if (matrix[start][m - 1] < target) {
                m--;
            } else if (matrix[start][m - 1] == target) {
                return true;
            } else {
                start++;
            }
        }
        return false;
    }
}