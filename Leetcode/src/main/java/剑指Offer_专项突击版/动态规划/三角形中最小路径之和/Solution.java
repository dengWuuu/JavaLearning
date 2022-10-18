package 剑指Offer_专项突击版.动态规划.三角形中最小路径之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wu
 * @date 2022年10月18日 13:25
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
        }


        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < triangle.get(i).size(); j++) {
                if (j == triangle.get(i).size() - 1) dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp[dp.length - 1].length; i++) {
            min = Math.min(min, dp[dp.length - 1][i]);
        }
        return min;

    }
}