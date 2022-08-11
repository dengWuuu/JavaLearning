package LeetCode.热题100.盛最多水的容器;

/**
 * @author Wu
 * @date 2022年08月09日 16:28
 */
public class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = Integer.MIN_VALUE;
        while (left <= right) {
            ans = Math.max(ans, (right - left) * Math.min(height[left], height[right]));
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}