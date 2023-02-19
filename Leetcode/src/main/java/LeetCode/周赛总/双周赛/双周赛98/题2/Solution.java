package LeetCode.周赛总.双周赛.双周赛98.题2;

import java.util.*;

/**
 * @author Wu
 * @date 2022年12月10日 22:16
 */
public class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        return Math.min(nums[nums.length - 2] - nums[1], Math.min(nums[nums.length - 1] - nums[2], nums[nums.length - 3] - nums[0]));
    }
}