package LeetCode.周赛总.单周塞.周赛318.长度为K子数组中的最大和;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Wu
 * @date 2022年11月06日 10:41
 */
public class Solution {
    public static long maximumSubarraySum(int[] nums, int k) {
        long max = 0;
        Set<Integer> set = new HashSet<>();
        int l = 0, r = 0;
        long sum = 0;
        while (r < nums.length) {
            while (r < nums.length && r >= l && r - l < k) {
                if (set.contains(nums[r])) {
                    while (set.contains(nums[r])) {
                        set.remove(nums[l]);
                        sum -= nums[l];
                        l++;
                    }
                } else {
                    sum += nums[r];
                    set.add(nums[r]);
                    r++;
                }
            }
            if (r - l == k) {
                max = Math.max(max, sum);
            }
            sum -= nums[l];
            set.remove(nums[l]);
            l++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maximumSubarraySum(new int[]{4, 4, 4}, 3));
    }
}