package 代码随想录.贪心.跳跃游戏;

/**
 * @author Wu
 * @date 2022年09月15日 20:01
 */
public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(nums[i] + i, cover);
            if (cover >= nums.length - 1) return true;
        }
        return false;
    }
}