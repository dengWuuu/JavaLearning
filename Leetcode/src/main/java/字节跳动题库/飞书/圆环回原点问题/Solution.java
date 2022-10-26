package 字节跳动题库.飞书.圆环回原点问题;

/**
 * 圆环上有10个点，编号为0~9。从0点出发，每次可以逆时针和顺时针走一步，问走n步回到0点共有多少种走法。
 *
 * @author Wu
 * @date 2022年10月26日 10:59
 */
public class Solution {
    public static int getNum(int n) {
        int[][] dp = new int[n + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = dp[i - 1][(j + n) % (n + 1)] + dp[i - 1][(j + 1) % (n + 1)];
            }
        }
        return dp[n][0];
    }

    public static void main(String[] args) {
        System.out.println(getNum(10));
    }
}
