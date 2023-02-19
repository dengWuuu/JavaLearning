package LeetCode.周赛总.单周塞.周赛333.题3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
//TODO 补状态压缩dp 和 背包
public class Solution {
    static {
        int MOD = (int) (1e9 + 7);
        int[] prime = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        int Max = 1024;
    }

    public int squareFreeSubsets(int[] nums) {
        int[] dp = new int[1024];
        dp[0] = 1;
        int n = nums.length;

        return 0;

    }
}