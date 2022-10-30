package LeetCode.周赛总.双周赛.双周赛90.摧毁一系列目标;

import java.util.*;

/**
 * @author Wu
 * @date 2022年10月29日 22:55
 */
public class Solution {

    public static int destroyTargets(int[] nums, int space) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i] % space, map.getOrDefault(nums[i] % space, 0) + 1);
        }

        int ansIdx = -1;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i] % space) > max) {
                max = map.get(nums[i] % space);
                ansIdx = i;
            } else if (map.get(nums[i] % space) > max && nums[i] < nums[ansIdx]) {
                ansIdx = i;
            }
        }
        return nums[ansIdx];
    }

}