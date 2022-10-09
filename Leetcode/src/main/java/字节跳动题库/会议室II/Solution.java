package 字节跳动题库.会议室II;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Wu
 * @date 2022年10月08日 19:21
 */
public class Solution {
    /**
     * 给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，返回 所需会议室的最小数量
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/meeting-rooms-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int minMeetingRooms(int[][] intervals) {

        if (intervals.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> allocator = new PriorityQueue<>(intervals.length, Comparator.comparingInt(a -> a));
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        allocator.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }

            allocator.add(intervals[i][1]);
        }

        return allocator.size();
    }
}

