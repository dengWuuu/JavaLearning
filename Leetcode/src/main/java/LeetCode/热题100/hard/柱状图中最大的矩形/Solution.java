package LeetCode.热题100.hard.柱状图中最大的矩形;

/**
 * @author Wu
 * @date 2022年08月20日 11:37
 */
public class Solution {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 0) return 0;
        if (n == 1) return heights[0];
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = -1;
        //找到该坐标，第一个小于当前坐标长度的矩形
        for (int i = 1; i < n; i++) {
            int min = i - 1;
            while (min >= 0 && heights[min] >= heights[i]) min = leftMax[min];
            leftMax[i] = min;
        }
        rightMax[n - 1] = n;
        for (int i = n - 2; i >= 0; i--) {
            int min = i + 1;
            while (min < n && heights[min] > heights[i]) min = rightMax[min];
            rightMax[i] = min;
        }
        // 求和
        int result = 0;
        for (int i = 0; i < n; i++) {
            int sum = heights[i] * (rightMax[i] - leftMax[i] - 1);
            result = Math.max(sum, result);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{}));
    }
}
