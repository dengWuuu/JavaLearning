package LeetCode.周赛总.单周塞.周赛338.题3;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{3, 1, 6, 8}, new int[]{1, 5}));
    }

    public static List<Long> minOperations(int[] nums, int[] queries) {
        List<Long> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        long[] preSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        for (int num : queries) {
            int r = binary(nums, num);
            int l = binary(nums, num - 1) - 1;
            long time = 0;
            time += Math.abs((long) (l + 1) * num - preSum[l + 1]);
            if (r < n) {
                time += Math.abs((long) (n - r) * num - (preSum[n] - preSum[r]));
            }
            ans.add(time);
        }
        return ans;
    }

    public static int binary(int[] nums, int num) {
        int l = -1, r = nums.length;
        while (l + 1 < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > num) r = mid;
            else l = mid;
        }
        return r;
    }
}