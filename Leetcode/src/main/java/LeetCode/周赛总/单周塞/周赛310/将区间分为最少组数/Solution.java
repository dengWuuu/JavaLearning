package LeetCode.周赛总.单周塞.周赛310.将区间分为最少组数;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Wu
 * @date 2022年09月11日 10:51
 */
public class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length, m = intervals[0].length;
        if (n <= 1) return 1;
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        int ans = 0;
        for (int[] interval : intervals) {
            if (queue.isEmpty() || interval[1] <= queue.peek()) {
                ans++;
            } else {
                queue.poll();
            }
            queue.add(interval[1]);
        }
        return ans;
    }
}
