package LeetCode.周赛总.单周塞.周赛340.题3;

import java.util.Arrays;

class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int l = -1, r = Integer.MAX_VALUE;
        while (l + 1 < r) {
            int mid = (l + r) / 2;
            if (check(nums, p, mid)) {
                r = mid;
            } else l = mid;
        }
        return r;
    }

    public boolean check(int[] nums, int p, int num) {
        int cnt = 0;
        int idx = 0;
        while (idx + 1 < nums.length) {
            if (Math.abs(nums[idx] - nums[idx + 1]) <= num) {
                cnt++;
                idx += 2;
            } else idx++;
        }

        return cnt >= p;
    }
}