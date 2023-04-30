package LeetCode.周赛总.单周塞.周赛343.题2;

import java.util.*;

/**
 * @author Wu
 * @date 2023年4月30日 10:21
 */
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < mat.length; i++) {
            int idx = Integer.MIN_VALUE;
            for (int j = 0; j < mat[0].length; j++) {
                idx = Math.max(idx, map.get(mat[i][j]));
            }
            ans = Math.min(ans, idx);
        }

        for (int i = 0; i < mat[0].length; i++) {
            int idx = Integer.MIN_VALUE;
            for (int j = 0; j < mat.length; j++) {
                idx = Math.max(idx, map.get(mat[j][i]));
            }
            ans = Math.min(ans, idx);
        }

        return ans;

    }
}