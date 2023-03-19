package LeetCode.周赛总.单周塞.周赛336.题2;

import java.util.*;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
class Solution {
    public static int maxScore(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        long cnt = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > 0) {
                sum += nums[i];
                cnt++;
            } else {
                sum += nums[i];
                if (sum > 0) {
                    cnt++;
                } else break;
            }
        }
        return (int) cnt;
    }

    public static void main(String[] args) {
        maxScore(new int[]{2, -1, 0, 1, -3, 3, -3});
    }
}