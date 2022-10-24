package LeetCode.二零二二年每日一题.十月.分割数组;

/**
 * @author Wu
 * @date 2022年10月24日 19:08
 */
public class Solution {
    public int partitionDisjoint(int[] nums) {
        int[] maxL = new int[nums.length];
        int[] minR = new int[nums.length];

        maxL[0] = nums[0];
        minR[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            maxL[i] = Math.max(maxL[i - 1], nums[i]);
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            minR[i] = Math.min(minR[i + 1], nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (maxL[i] <= minR[i + 1]) return i + 1;
        }
        return nums.length;
    }
}