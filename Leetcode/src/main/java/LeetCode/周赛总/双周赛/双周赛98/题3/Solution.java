package LeetCode.周赛总.双周赛.双周赛98.题3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Wu
 * @date 2022年12月10日 22:16
 */
class Solution {
    Set<Integer> set = new HashSet<>();

    public int minImpossibleOR(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] > 1) return 1;
        for (int num : nums) {
            set.add(num);
        }
        int min = 2;
        while (set.contains(min)) {
            min *= 2;
        }
        return min;

    }
}