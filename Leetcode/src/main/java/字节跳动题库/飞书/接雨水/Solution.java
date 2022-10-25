package 字节跳动题库.飞书.接雨水;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wu
 * @date 2022年10月25日 20:38
 */
public class Solution {
    public static int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        int ans = 0;
        for (int i = 1; i < height.length; i++) {
            if (stack.isEmpty() || height[i] < height[stack.peek()]) {
                stack.push(i);
            } else if (height[i] == height[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else {
                while (height[stack.peek()] < height[i]) {
                    int mid = stack.pop();
                    if (stack.isEmpty()) break;
                    int left = stack.peek();
                    int len = i - 1 - stack.peek();
                    ans += (Math.min(height[left], height[i]) - height[mid]) * len;
                }
                stack.push(i);
            }
        }
        return ans;
    }


    public int otherSolution(int[] height) {
        int l = 0, r = height.length - 1, lMax = 0, rMax = 0;
        int ans = 0;
        while (l < r) {
            lMax = Math.max(lMax, height[l]);
            rMax = Math.max(rMax, height[r]);
            if (lMax < rMax) {
                ans += lMax - height[l++];
            } else {
                ans += rMax - height[r--];
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}