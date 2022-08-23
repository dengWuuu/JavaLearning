package LeetCode.热题100.不同的二叉搜索树;

/**
 * @author Wu
 * @date 2022年08月23日 12:30
 */
public class Solution {
    int[] dp;

    public int numTrees(int n) {
        if (n <= 1) return n;
        dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
