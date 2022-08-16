package LeetCode.热题100.跳跃游戏II;

/**
 * @author Wu
 * @date 2022年08月15日 10:37
 */
public class Solution {
    public static int jump(int[] nums) {
        int length = nums.length;
        int ans = 0;
        int end = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length - 1; i++) {
            max = Math.max(max, nums[i] + i);
            if (i == end) {
                end = max;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    }
}