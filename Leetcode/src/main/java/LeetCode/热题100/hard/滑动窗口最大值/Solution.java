package LeetCode.热题100.hard.滑动窗口最大值;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wu
 * @date 2022年08月29日 9:16
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> max = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!max.isEmpty() && nums[i] >= nums[max.peekLast()]) {
                max.pollLast();
            }
            max.add(i);
        }
        ans[0] = nums[max.peek()];

        for (int i = k; i < n; i++) {
            while (!max.isEmpty() && nums[i] >= nums[max.peekLast()]) {
                max.pollLast();
            }
            max.add(i);
            while (!max.isEmpty() && max.peek() <= i - k) max.poll();
            ans[i - k + 1] = nums[max.peekFirst()];
        }
        return ans;
    }
}
