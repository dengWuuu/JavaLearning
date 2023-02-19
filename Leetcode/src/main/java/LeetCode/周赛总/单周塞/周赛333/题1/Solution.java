package LeetCode.周赛总.单周塞.周赛333.题1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
public class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int l = 0, r = 0;
        List<int[]> ans = new ArrayList<>();
        while (l < nums1.length || r < nums2.length) {
            int lval = l < nums1.length ? nums1[l][0] : Integer.MAX_VALUE;
            int rval = r < nums2.length ? nums2[r][0] : Integer.MAX_VALUE;
            if (lval < rval) {
                ans.add(new int[]{lval, nums1[l][1]});
                l++;
            } else if (lval > rval) {
                ans.add(new int[]{rval, nums2[r][1]});
                r++;
            } else {
                ans.add(new int[]{lval, nums1[l][1] + nums2[r][1]});
                l++;
                r++;
            }
        }

        return ans.toArray(new int[0][]);
    }
}