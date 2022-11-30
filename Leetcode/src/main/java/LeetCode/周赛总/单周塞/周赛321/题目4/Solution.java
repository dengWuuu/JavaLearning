package LeetCode.周赛总.单周塞.周赛321.题目4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年11月20日 9:56
 */
public class Solution {
    public static int countSubarrays(int[] nums, int k) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                idx = i;
                break;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        map.put(0, 1);
        for (int i = idx + 1; i < nums.length; i++) {
            if (nums[i] > k) cnt++;
            else cnt--;
            map.put(cnt, map.getOrDefault(cnt, 0) + 1);
        }

        int ans = map.get(0) + map.getOrDefault(1, 0);
        cnt = 0;
        for (int i = idx - 1; i >= 0; i--) {
            if (nums[i] < k) cnt++;
            else cnt--;
            ans += map.getOrDefault(cnt, 0) + map.getOrDefault(cnt + 1, 0);
        }
        return ans;
    }
}