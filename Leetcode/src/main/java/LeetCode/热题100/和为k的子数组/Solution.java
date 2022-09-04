package LeetCode.热题100.和为k的子数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年09月02日 11:38
 */
public class Solution {
    public static int subarraySum(int[] nums, int k) {
        int ans = 0, pre = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        for (int num : nums) {
            pre += num;
            if (hashMap.containsKey(pre - k)) {
                ans += hashMap.get(pre - k);
            }
            hashMap.put(pre, hashMap.getOrDefault(pre, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{0,0}, 0));
    }

}
