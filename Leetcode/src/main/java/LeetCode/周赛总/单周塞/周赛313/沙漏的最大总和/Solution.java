package LeetCode.周赛总.单周塞.周赛313.沙漏的最大总和;

/**
 * @author Wu
 * @date 2022年10月02日 10:33
 */
public class Solution {
    public static int maxSum(int[][] grid) {
        int ans = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i <= m - 3; i++) {
            for (int j = 1; j <= n - 2; j++) {
                int sum = grid[i][j] + grid[i][j - 1] + grid[i][j + 1] + grid[i + 1][j] + grid[i + 2][j] + grid[i + 2][j - 1] + grid[i + 2][j + 1];
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }
}
