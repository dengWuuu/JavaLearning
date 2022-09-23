package 代码随想录.单调栈.接雨水;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年09月23日 14:16
 */
public class Solution {
    /**
     * 单调栈方法
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        if (height.length <= 2) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int mid = height[stack.pop()];
                if (!stack.isEmpty()) {
                    int h = Math.min(height[i], height[stack.peek()]) - mid;
                    int w = i - 1 - stack.peek();
                    sum += h * w;
                }
            }
            stack.push(i);
        }
        return sum;
    }

    /**
     * 双指针法
     *
     * @return
     */
    public int trap2(int[] height) {
        int left = 0, right = height.length - 1, leftMax = 0, rightMax = 0;
        int ans = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                left++;
            } else {
                ans += rightMax - height[right];
                right++;
            }
        }
        return ans;
    }

    /**
     * 动态规划法
     *
     * @return
     */
    public int trap3(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        //初始化dp数组
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 1; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            if (i == 0 || i == height.length - 1) {
                continue;
            }
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return ans;
    }
}
