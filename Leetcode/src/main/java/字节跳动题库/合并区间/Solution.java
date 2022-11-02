package 字节跳动题库.合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Wu
 * @date 2022年11月02日 15:58
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));

        List<int[]> ans = new ArrayList<>();
        ans.add(new int[]{intervals[0][0], intervals[0][1]});
        for (int i = 1; i < intervals.length; i++) {
            int x = intervals[i][0], y = intervals[i][1];
            if (x <= ans.get(ans.size() - 1)[1] && y >= ans.get(ans.size() - 1)[1]) {
                int[] ints = ans.get(ans.size() - 1);
                ints[1] = y;
                ans.set(ans.size() - 1, ints);
            } else if (x <= ans.get(ans.size() - 1)[1] && y <= ans.get(ans.size() - 1)[1]) {
                continue;
            } else {
                ans.add(new int[]{x, y});
            }
        }

        return ans.toArray(new int[0][]);
    }
}
