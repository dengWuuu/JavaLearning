package LeetCode.周赛总.单周塞.周赛335.题3;

import java.util.*;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */

public class Solution {

    public static int findValidSplit(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l + 1 < r) {
            long max = Math.max(nums[r], nums[l]);
            long min = Math.min(nums[l], nums[r]);
            if (gcd(max, min) == 1) {
                r--;
            } else {
                l = r;
                break;
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= l; i++) {
            int num = nums[i];
            set.add(num);
            for (int j = 2; j * j <= num; j++) {
                while (num % j == 0) {
                    num /= j;
                    set.add(num);
                }
            }
        }
        for (int i = l + 1; i < nums.length; i++) {
            int num = nums[i];
            for (int j = 1; j * j <= num; j++) {
                if (num % j == 0) {
                    if (j == 1) {
                        if (set.contains(num)) {
                            l = i;
                            set.add(num);
                        }
                    } else if (set.contains(j) || set.contains(num / j)) {
                        l = i;
                        set.add(j);
                        set.add(num / j);
                    }
                }
            }
        }
        return l == nums.length - 1 ? -1 : l;
    }

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}