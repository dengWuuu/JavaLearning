package LeetCode.周赛总.单周塞.周赛315.与对应负数同时存在的最大正整数;

import java.util.*;

/**
 * @author Wu
 * @date 2022年10月16日 10:30
 */
public class Solution {
    public static int findMaxK(int[] nums) {
        Set<Integer> map = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            map.add(nums[i]);
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length && nums[i] < 0; i++) {
            if (map.contains(-nums[i])) return -nums[i];
        }
        return -1;

    }


}
