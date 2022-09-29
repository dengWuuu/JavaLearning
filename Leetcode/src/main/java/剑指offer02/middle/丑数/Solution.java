package 剑指offer02.middle.丑数;

/**
 * @author Wu
 * @date 2022年08月02日 18:16
 */
public class Solution {
    static int[] dp;

    public static int nthUglyNumber(int n) {
        dp = new int[1700];
        dp[0] = 1;
        int i = 0, j = 0, k = 0;
        for (int index = 1; index < n; index++) {
            int tmp = Math.min(Math.min(dp[i] * 2, dp[j] * 3), dp[k] * 5);
            if (tmp == dp[i] * 2) i++;
            if (tmp == dp[j] * 3) j++;
            if (tmp == dp[k] * 5) k++;
            dp[index] = tmp;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        nthUglyNumber(10);
    }
}
