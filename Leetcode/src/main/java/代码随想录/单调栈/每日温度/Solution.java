package 代码随想录.单调栈.每日温度;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Wu
 * @date 2022年09月22日 19:57
 */
public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    ans[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return ans;
    }
}
