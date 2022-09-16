package 代码随想录.贪心.跳跃游戏II;

/**
 * @author Wu
 * @date 2022年09月15日 20:24
 */
public class Solution {
    public int jump(int[] nums) {
        int ans = 0, max = Integer.MIN_VALUE, end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i] + i);
            if (end == i) {
                ans++;
                end = max;
            }
        }
        return ans;
    }
}