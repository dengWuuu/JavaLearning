package LeetCode.周赛总.单周塞.周赛340.题2;

import java.util.*;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
class Solution {
    public static long[] distance(int[] nums) {
        long[] ans = new long[nums.length];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                map.put(nums[i], new ArrayList<>());
                map.get(nums[i]).add(i);
            }
        }

        Map<Integer, long[]> pre = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> l : map.entrySet()) {
            Integer key = l.getKey();
            List<Integer> value = l.getValue();

            long[] preSum = new long[value.size() + 1];
            for (int i = 1; i <= value.size(); i++) {
                preSum[i] = preSum[i - 1] + value.get(i - 1);
            }
            pre.put(key, preSum);
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            var l = map.get(num);
            var prefix = pre.get(num);
            if (l.size() == 1) {
                continue;
            }
            long all = prefix[prefix.length - 1];
            long sum = 0;

            int idx = binary(l, i);
            if (idx >= 0) sum += (long) idx * i - prefix[idx];
            if (idx >= 0) sum += (all - prefix[idx]) - (long) (prefix.length - 1 - idx) * i;

            ans[i] = sum;
        }
        return ans;
    }

    public static int binary(List<Integer> list, int num) {
        int l = -1, r = list.size();
        while (l + 1 < r) {
            int mid = (l + r) / 2;
            if (num == list.get(mid)) return mid;
            else if (num > list.get(mid)) l = mid;
            else r = mid;
        }
        return -1;
    }
}