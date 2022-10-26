package 字节跳动题库.飞书.跳跃游戏II;

/**
 * @author Wu
 * @date 2022年10月26日 15:25
 */
public class Solution {
    public int jump(int[] nums) {
        int ans = 0, end = nums[0], max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i] + max);
            if (i == end) {
                end = max;
                ans++;
            }
        }
        return ans;

    }
}