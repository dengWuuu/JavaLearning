package LeetCode.热题100.跳跃游戏;

/**
 * @author Wu
 * @date 2022年08月16日 10:47
 */
public class Solution {
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int end = 0, max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == end && end == max) break;

            if (i == end) {
                end = max;
            }
        }
        return max >= n - 1;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
