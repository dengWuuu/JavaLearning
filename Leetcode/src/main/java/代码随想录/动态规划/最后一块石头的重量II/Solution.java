package 代码随想录.动态规划.最后一块石头的重量II;

/**
 * @author Wu
 * @date 2022年09月18日 16:24
 */
public class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int mid = sum / 2;
        int[] dp = new int[mid + 1];
        for (int stone : stones) {
            for (int j = mid; j >= stone; j--) {
                dp[j] = Math.max(dp[j], dp[j - stone] + stone);
            }
        }
        return sum - dp[mid] * 2;
    }
}
