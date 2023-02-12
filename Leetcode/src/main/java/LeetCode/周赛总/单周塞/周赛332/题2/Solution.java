package LeetCode.周赛总.单周塞.周赛332.题2;

import java.util.*;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        long ans = 0;
        int r = nums.length - 1;
        for (int i = 0; i < r; i++) {
            int lmin = lower - nums[i];
            int i1 = binarySearch(nums, lmin, i, r);
            int rmax = upper - nums[i];
            int i2 = binarySearch(nums, rmax, i, r) - 1;
            ans += i2 - i1 + 1;
        }
        return ans;
    }
    public int binarySearch(int[] nums, int target, int l1, int r1) {
        int l = l1, r = r1;
        while (l + 1 < r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else l = mid;
        }
        return r;
    }
}