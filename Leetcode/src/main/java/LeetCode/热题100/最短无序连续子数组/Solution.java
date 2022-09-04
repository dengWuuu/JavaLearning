package LeetCode.热题100.最短无序连续子数组;

/**
 * https://leetcode.cn/problems/shortest-unsorted-continuous-subarray/?favorite=2cktkvj
 *
 * @author Wu
 * @date 2022年09月03日 20:33
 */
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int high = Integer.MIN_VALUE, low = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[n - i - 1]);
            if(nums[i] < max) high = i;
            if(nums[n - i - 1] > min) low = n - i - 1;
        }
        return high > low ? high - low + 1 : 0;
    }
}