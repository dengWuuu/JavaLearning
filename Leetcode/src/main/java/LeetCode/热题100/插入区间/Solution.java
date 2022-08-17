package LeetCode.热题100.插入区间;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/insert-interval/
 *
 * @author Wu
 * @date 2022年08月16日 11:18
 */
public class Solution {
    List<int[]> ans = new ArrayList<>();

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int newLeft = newInterval[0], newRight = newInterval[1];
        boolean isInsert = false;

        for (int[] interval : intervals) {
            if (interval[1] < newLeft) {
                ans.add(interval);
            } else if (interval[0] > newRight) {
                if (!isInsert) {
                    ans.add(new int[]{newLeft, newRight});
                    isInsert = true;
                }
                ans.add(interval);
            } else {
                newLeft = Math.min(newLeft, interval[0]);
                newRight = Math.max(newRight, interval[1]);
            }
        }

        if (!isInsert) {
            ans.add(new int[]{newLeft, newRight});
        }
        return ans.toArray(new int[0][]);
    }
}
