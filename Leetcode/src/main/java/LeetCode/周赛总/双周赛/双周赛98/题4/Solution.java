package LeetCode.周赛总.双周赛.双周赛98.题4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年12月10日 22:16
 */
//TODO 补线段树
public class Solution {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        int[] preSum1 = new int[nums1.length + 1];

        for (int i = 0; i < nums1.length; i++) {
            preSum1[i + 1] = preSum1[i] + nums1[i];
        }


        List<Long> ans = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], y = queries[i][1], z = queries[i][2];
            if (x == 1) {

            } else if (x == 2) {

            } else {

            }
        }
        return null;


    }
}