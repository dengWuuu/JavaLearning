package LeetCode.热题100.每日温度;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wu
 * @date 2022年09月04日 15:06
 */
public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && temperatures[stack.peekLast()] < temperatures[i]) {
                    ans[stack.peekLast()] = i - stack.peekLast();
                    stack.pollLast();
                }
            }
            stack.add(i);
        }
        return ans;
    }
}
