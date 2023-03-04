package LeetCode.周赛总.单周塞.周赛334.题3;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */

public class Solution {
    public static int maxNumOfMarkedIndices(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);

        int l = nums.length / 2, r = nums.length - 1;
        while (l >= 0) {
            if (nums[l] * 2 <= nums[r]) {
                ans += 2;
                l--;
                r--;
            } else l--;

        }
        return ans;
    }
}