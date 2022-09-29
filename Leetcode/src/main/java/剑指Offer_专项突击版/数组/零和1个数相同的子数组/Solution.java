package 剑指Offer_专项突击版.数组.零和1个数相同的子数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年09月28日 10:53
 */
public class Solution {
    public static int findMaxLength(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;
        int ans = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(count, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                count--;
            }
            if (map.containsKey(count)) {
                ans = Math.max(ans, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return ans;
    }
}
