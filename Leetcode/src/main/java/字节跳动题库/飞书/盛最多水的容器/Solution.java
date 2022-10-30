package 字节跳动题库.飞书.盛最多水的容器;

import java.util.Map;

/**
 * @author Wu
 * @date 2022年10月29日 21:30
 */
public class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                ans = Math.max(ans, (right - left) * height[left]);
                left++;
            } else {
                ans = Math.max(ans, (right - left) * height[right]);
                right--;
            }
        }
        return ans;
    }
}
