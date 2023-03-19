package LeetCode.周赛总.单周塞.周赛337.题4;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int l = -1, r = (int) (1e9 + 1);
        while (l + 1 < r) {
            int mid = (r + l) / 2;
            if (check(nums, value, mid)) {
                l = mid;
            } else r = mid;
        }
        return l;
    }

    public boolean check(int[] nums, int value, int mex) {
        if (mex > nums.length) return false;
        int[] cnt = new int[value];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i] % value;
            if (num < 0) num += value;
            cnt[num]++;
        }
        int cur = 0;
        int idx = 0;
        while (cnt[idx] != 0) {
            cur++;
            cnt[idx]--;
            idx = (idx + 1) >= value ? 0 : idx + 1;
        }
        return cur >= mex;
    }
}
