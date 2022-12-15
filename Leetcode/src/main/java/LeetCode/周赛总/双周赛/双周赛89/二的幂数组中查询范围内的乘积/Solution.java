package LeetCode.周赛总.双周赛.双周赛89.二的幂数组中查询范围内的乘积;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年10月15日 22:47
 */
public class Solution {
    public static int[] productQueries(int n, int[][] queries) {
        int[] ans = new int[queries.length];
        int MOD = (int) (Math.pow(10, 9) + 7);
        List<Integer> powerL = new ArrayList<>();
        int sum = 1;
        while (sum < n) {
            sum *= 2;
        }
        if (sum > n) {

            sum /= 2;
        }
        while (n > 0) {
            if (sum <= n) {
                powerL.add(0, sum);
                n -= sum;
            } else {
                while (sum > n) {
                    sum /= 2;
                }
            }
        }

        for (int i = 0; i < ans.length; i++) {
            long x = 1;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                x *= powerL.get(j);
                x %= MOD;
            }
            if (x == -147483634) ans[i] = 147483634;
            ans[i] = (int) x;
        }

        return ans;
    }
}