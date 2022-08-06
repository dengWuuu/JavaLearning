package LeetCode.剑指offer02.hard.滑动窗口的最大值;

import java.util.*;

/**
 * @author Wu
 * @date 2022年08月04日 16:20
 */
public class Solution {
    Deque<Integer> max = new ArrayDeque<>();

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        int[] ans = new int[nums.length - k + 1];
        for (int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            if (i > 0 && max.peekFirst() == nums[i - 1]) {
                max.removeFirst();
            }
            while (!max.isEmpty() && nums[j] > max.peekLast()) {
                max.removeLast();
            }
            max.addLast(nums[j]);
            if (i >= 0) {
                ans[i] = max.peekFirst();
            }
        }
        return ans;

    }
}
