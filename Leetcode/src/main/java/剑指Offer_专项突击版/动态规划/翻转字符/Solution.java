package 剑指Offer_专项突击版.动态规划.翻转字符;

/**
 * @author Wu
 * @date 2022年10月14日 20:22
 */
public class Solution {
    //dp[i][0]表示前i个元素，最后一个元素为0的最小翻转次数；
    //dp[i][1]表示前i个元素，最后一个元素为1的最小翻转次数
    public int minFlipsMonoIncr(String s) {
        int dp[][] = new int[s.length()][2];
        //初始化
        dp[0][0] = s.charAt(0) == '0' ? 0 : 1;
        dp[0][1] = s.charAt(0) == '1' ? 0 : 1;
        //状态转移
        for (int i = 1; i < s.length(); i++) {
            dp[i][0] = dp[i - 1][0] + (s.charAt(i) == '0' ? 0 : 1);
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (s.charAt(i) == '1' ? 0 : 1);
        }
        return Math.min(dp[s.length() - 1][0], dp[s.length() - 1][1]);
    }
}