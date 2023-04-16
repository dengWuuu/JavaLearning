package LeetCode.周赛总.单周塞.周赛341.题2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int max = 0;
        int idx = 0;
        for (int i = 0; i < divisors.length; i++) {
            int cnt = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] % divisors[i] == 0) cnt++;
            }
            if (cnt > max) {
                max = cnt;
                idx = i;
            } else if (cnt == max && divisors[i] < divisors[idx]) {
                idx = i;
            }
        }
        return divisors[idx];
    }
}