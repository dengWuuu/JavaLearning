package LeetCode.周赛总.单周塞.周赛334.题1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
public class Solution {
    public int[] leftRigthDifference(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            left[i] = nums[i - 1] + left[i - 1];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = nums[i + 1] + right[i + 1];
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = Math.abs(left[i] - right[i]);
        }
        return ans;
    }
}