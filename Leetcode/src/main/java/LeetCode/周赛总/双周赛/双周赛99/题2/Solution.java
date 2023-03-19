package LeetCode.周赛总.双周赛.双周赛99.题2;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年12月10日 22:16
 */
public class Solution {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;

        int cur = nums.length - 2;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (cur >= 0) {
                if (nums[i] > nums[cur]) {
                    ans++;
                    cur--;
                    break;
                } else cur--;
            }
            if (cur < 0) break;
        }

        return ans;
    }
}