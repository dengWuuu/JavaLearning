package LeetCode.力扣2022秋季大赛.气温变化趋势;

/**
 * @author Wu
 * @date 2022年09月24日 15:00
 */
public class Solution {
    public static int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int n = temperatureA.length;
        int[] dp = new int[n + 1];
        if ((temperatureA[0] == temperatureA[1] && temperatureB[0] == temperatureB[1])
                || (temperatureA[1] > temperatureA[0] && temperatureB[1] > temperatureB[0])
                || (temperatureA[1] < temperatureA[0] && temperatureB[1] < temperatureB[0])) {
            dp[0] = 1;
        } else dp[0] = 0;
        int ans = dp[0];
        for (int i = 1; i < temperatureA.length - 1; i++) {
            if ((temperatureA[i] == temperatureA[i + 1] && temperatureB[i] == temperatureB[i + 1])
                    || (temperatureA[i + 1] > temperatureA[i] && temperatureB[i + 1] > temperatureB[i])
                    || (temperatureA[i + 1] < temperatureA[i] && temperatureB[i + 1] < temperatureB[i])) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 0;
            }
            ans = Math.max(dp[i], ans);
        }

        return ans;
    }
}
