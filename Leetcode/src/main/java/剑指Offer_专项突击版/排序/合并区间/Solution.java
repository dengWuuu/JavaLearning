package 剑指Offer_专项突击版.排序.合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wu
 * @date 2022年10月11日 18:38
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        if (intervals == null) return ans.toArray(new int[0][]);
        Arrays.sort(intervals, (x, y) -> {
            return x[0] == y[0] ? x[1] - y[1] : x[0] - y[0];
        });

        ans.add(new int[]{intervals[0][0], intervals[0][1]});

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= ans.get(ans.size() - 1)[1] && intervals[i][1] > ans.get(ans.size() - 1)[1]) {
                ans.get(ans.size() - 1)[1] = intervals[i][1];
            } else if (intervals[i][0] > ans.get(ans.size() - 1)[1]) {
                ans.add(new int[]{intervals[i][0], intervals[i][1]});
            }
        }

        return ans.toArray(new int[0][]);
    }
}