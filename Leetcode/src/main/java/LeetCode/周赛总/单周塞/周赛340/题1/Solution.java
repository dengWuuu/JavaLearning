package LeetCode.周赛总.单周塞.周赛340.题1;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
public class Solution {
    static boolean[] zhishu = new boolean[(int) (4 * 1e6) + 100];

    static {
        long n = (int) (4 * 1e6) + 10;
        Arrays.fill(zhishu, true);
        zhishu[0] = false;
        zhishu[1] = false;
        for (int i = 2; (long) i * i <= n; i++) {
            if (zhishu[i]) {
                for (long j = (long) i * i; j <= n; j += i) {
                    zhishu[(int) j] = false;
                }
            }
        }
    }

    public int diagonalPrime(int[][] nums) {
        int ans = 0;
        int m = nums.length;
        int x = 0, y = 0;
        while (x < m && y < m) {
            int num = nums[x][y];
            if (zhishu[num] && num > ans) {
                ans = num;
            }
            x++;
            y++;
        }

        x = 0;
        y = m - 1;
        while (x < m && y >= 0) {
            int num = nums[x][y];
            if (zhishu[num] && num > ans){
                ans = num;
            }
            x++;
            y--;
        }
        return ans;
    }
}