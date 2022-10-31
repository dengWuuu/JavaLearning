package 字节跳动题库.飞书.对角线遍历;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年10月31日 18:55
 */
public class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] ans = new int[m * n];
        int[] start = {0, 0};
        int idx = 0;
        int times = 0;
        while (start[0] != m && start[1] != n) {
            int x = start[0], y = start[1];
            if (times % 2 == 0) {
                while (x >= 0 && x < mat.length && y >= 0 && y < mat[0].length) {
                    ans[idx++] = mat[x][y];
                    x--;
                    y++;
                }
                if (y == n) {
                    start[0] = x + 2;
                    start[1] = y - 1;
                } else {
                    start[0] = x + 1;
                    start[1] = y;
                }
            } else {
                while (x >= 0 && x < mat.length && y >= 0 && y < mat[0].length) {
                    ans[idx++] = mat[x][y];
                    x++;
                    y--;
                }
                if (x == m) {
                    start[0] = x - 1;
                    start[1] = y + 2;
                } else {
                    start[0] = x;
                    start[1] = y + 1;
                }
            }
            times++;
        }
        ans[idx] = mat[m - 1][n - 1];
        return ans;
    }
}