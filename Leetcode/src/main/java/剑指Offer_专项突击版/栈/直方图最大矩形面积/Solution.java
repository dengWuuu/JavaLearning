package 剑指Offer_专项突击版.栈.直方图最大矩形面积;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static int largestRectangleArea(int[] heights) {
        int ans = 0;
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, newHeights.length - 2);
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i < newHeights.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            if (newHeights[i] >= newHeights[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                    int mid = stack.pop();
                    int left = stack.peek();
                    ans = Math.max(ans, (i - left - 1) * newHeights[mid]);
                }
                stack.push(i);
            }
        }
        return ans;
    }
}
