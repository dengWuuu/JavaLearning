package LeetCode.周赛总.双周赛.双周赛91.题1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Double> set = new HashSet<>();

    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        double sum = 0;

        int l = 0, r = nums.length - 1;
        for (int i = 1; i <= nums.length / 2; i++) {
            double cur = (nums[l++] + nums[r--]) / 2.0;
            set.add(cur);
            l++;
            r--;
        }
        return set.size();
    }
}