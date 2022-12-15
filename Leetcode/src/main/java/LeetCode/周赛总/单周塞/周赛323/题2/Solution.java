package LeetCode.周赛总.单周塞.周赛323.题2;

import java.util.*;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
public class Solution {
    public int longestSquareStreak(int[] nums) {
        int ans = -1;
        Arrays.sort(nums);

        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int sum = nums[i];
            int a = 1;
            while (set.contains(sum * sum)) {
                a++;
                sum *= sum;
            }
            if (a != 1) ans = Math.max(ans, a);
        }
        return ans;
    }
}