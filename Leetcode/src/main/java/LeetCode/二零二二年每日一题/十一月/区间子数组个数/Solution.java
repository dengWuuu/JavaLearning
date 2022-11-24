package LeetCode.二零二二年每日一题.十一月.区间子数组个数;

public class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int ans = 0, max = -1, cur = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > right) max = i;
            if (nums[i] < right && nums[i] >= left) cur = i;
            ans += cur - max;
        }
        return ans;
    }
}