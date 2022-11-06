package LeetCode.周赛总.单周塞.周赛312.找到所有好下标;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年09月25日 11:01
 */
public class Solution {
    public static List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        int[] dpL = new int[nums.length];
        int[] dpR = new int[nums.length];
        dpL[0] = 1;
        dpR[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) dpL[i] = dpL[i - 1] + 1;
            else dpL[i] = 1;
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1]) dpR[i] = dpR[i + 1] + 1;
            else dpR[i] = 1;
        }

        for (int i = k; i < nums.length - k; i++) {
            if (dpL[i - 1] >= k && dpR[i + 1] >= k) ans.add(i);
        }
        return ans;
    }
}
