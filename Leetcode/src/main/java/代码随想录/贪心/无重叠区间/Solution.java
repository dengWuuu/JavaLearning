package 代码随想录.贪心.无重叠区间;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Wu
 * @date 2022年09月16日 14:19
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[1]));
        if (intervals.length <= 1) return 0;
        int count = 1, R = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (R <= intervals[i][0]) {
                R = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }
}
