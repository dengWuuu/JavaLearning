package LeetCode.周赛总.单周塞.周赛324.题4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
public class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], y = queries[i][1];
            int res = 0;
            while (x != y) {
                if (x > y) x /= 2;
                else y /= 2;
                res++;
            }
            ans[i] = res + 1;
        }
        return ans;
    }
}