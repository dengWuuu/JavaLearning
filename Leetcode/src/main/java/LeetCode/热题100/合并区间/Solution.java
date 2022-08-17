package LeetCode.热题100.合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.cn/problems/merge-intervals/
 *
 * @author Wu
 * @date 2022年08月16日 11:06
 */
public class Solution {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][2];
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> ans = new ArrayList<>();

        for (int[] interval : intervals) {
            int L = interval[0], R = interval[1];
            if (ans.size() == 0 || ans.get(ans.size() - 1)[1] < L) {
                ans.add(new int[]{L, R});
            } else {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], R);
            }
        }
        return ans.toArray(new int[0][]);
    }
}
