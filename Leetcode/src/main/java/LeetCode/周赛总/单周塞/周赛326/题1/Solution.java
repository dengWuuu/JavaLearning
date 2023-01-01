package LeetCode.周赛总.单周塞.周赛326.题1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
public class Solution {
    public int countDigits(int num) {
        List<Integer> nums = new ArrayList<>();
        cnt(num, nums);
        int ans = 0;
        for (Integer integer : nums) {
            if (num % integer == 0) ans++;
        }
        return ans;
    }

    public void cnt(int num, List<Integer> list) {
        while (num > 0) {
            list.add(num % 10);
            num /= 10;
        }
    }
}