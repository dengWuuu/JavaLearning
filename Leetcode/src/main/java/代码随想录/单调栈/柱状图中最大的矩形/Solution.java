package 代码随想录.单调栈.柱状图中最大的矩形;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wu
 * @date 2022年09月23日 19:01
 */
public class Solution {
    public static int largestRectangleArea(int[] heights) {
        Deque<Integer> st = new LinkedList<>();
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        System.arraycopy(heights, 0, newHeights, 1, heights.length);
        heights = newHeights;
        st.push(0);
        int result = 0;
        for (int i = 1; i < heights.length; i++) {
            while (heights[i] < heights[st.peek()]) {
                int h = heights[st.pop()];
                int w = i - st.peek() - 1;
                result = Math.max(result, w * h);
            }
            st.push(i);
        }
        return result;
    }
}
