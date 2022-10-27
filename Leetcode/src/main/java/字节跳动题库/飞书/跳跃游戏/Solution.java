package 字节跳动题库.飞书.跳跃游戏;

/**
 * @author Wu
 * @date 2022年10月27日 9:37
 */
public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        int max = 0, end = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i] + i);
            if (i == end) {
                if (max == end || i == nums.length - 1) return false;
                end = max;
            }
        }
        return true;
    }
}