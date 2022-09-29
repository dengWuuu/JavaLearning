package 剑指Offer_专项突击版.数组.和为k的子数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年09月27日 18:08
 */
public class Solution {
    public static int subarraySum(int[] nums, int k) {
        int sum = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 2, 3, -3, 3}, 3));
    }
}
