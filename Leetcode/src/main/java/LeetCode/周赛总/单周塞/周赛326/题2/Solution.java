package LeetCode.周赛总.单周塞.周赛326.题2;

import java.util.*;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
public class Solution {
    public int distinctPrimeFactors(int[] nums) {
        List<Integer> zhishu = new ArrayList<>();
        int i, j;
        for (i = 1; i <= 1000; i++) {
            for (j = 2; j < i; j++) {
                if (i % j == 0) break;
            }
            if (i == j) zhishu.add(j);
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            for (Integer integer : zhishu) {
                if (integer > num) break;
                if (num % integer == 0) set.add(integer);
            }
        }
        return set.size();

    }
}