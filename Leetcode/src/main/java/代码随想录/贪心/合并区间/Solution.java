package 代码随想录.贪心.合并区间;

import java.util.*;

/**
 * @author Wu
 * @date 2022年09月17日 9:36
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        int left = 0, right = 1;
        while (right < intervals.length) {
            int L = intervals[left][0], R = intervals[left][1];
            while (right < intervals.length && intervals[right][0] <= R) {
                R = Math.max(R, intervals[right][1]);
                right++;
            }
            left = right;
            ans.add(new int[]{L, R});
        }

        return ans.toArray(new int[0][]);
    }
}
