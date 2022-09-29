package 剑指offer02.middle.把数字翻译成字符串;

/**
 * @author Wu
 * @date 2022年08月02日 10:52
 */
public class Solution {
    static int[] dp;
    public static int translateNum(int num) {
        dp = new int[32];
        String strNums = String.valueOf(num);
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= strNums.length(); i++) {
            String tmp = strNums.substring(i - 2, i);
            if (tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 && strNums.charAt(i - 2) != '0') {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }

        }
        return dp[strNums.length()];
    }
}