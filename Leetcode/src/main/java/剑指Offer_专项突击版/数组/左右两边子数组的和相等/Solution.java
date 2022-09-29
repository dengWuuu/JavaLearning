package 剑指Offer_专项突击版.数组.左右两边子数组的和相等;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年09月27日 18:40
 */
public class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (total - 2 * sum == nums[i]) {
                return i;
            }
            sum += nums[i];
        }
        return -1;

    }
}
