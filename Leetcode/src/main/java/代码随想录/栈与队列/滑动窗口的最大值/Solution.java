package 代码随想录.栈与队列.滑动窗口的最大值;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Wu
 * @date 2022年09月09日 8:59
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k];
        Deque<Integer> deque = new ArrayDeque<>();
        int idx = 0;
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.add(i);
            if (i >= k - 1) {
                ans[idx++] = nums[deque.peekFirst()];

            }
        }
        return ans;
    }
}