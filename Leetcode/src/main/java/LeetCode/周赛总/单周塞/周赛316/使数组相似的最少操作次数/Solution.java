package LeetCode.周赛总.单周塞.周赛316.使数组相似的最少操作次数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Wu
 * @date 2022年10月23日 11:34
 */
public class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        if (nums.length == 0 && target.length == 0) return 0;
        if (Arrays.equals(nums, target)) return 0;
        List<Integer> nums1 = new ArrayList<>();
        List<Integer> nums2 = new ArrayList<>();
        List<Integer> target1 = new ArrayList<>();
        List<Integer> target2 = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) nums1.add(nums[i]);
            else nums2.add(nums[i]);

            if (target[i] % 2 == 0) target1.add(target[i]);
            else target2.add(target[i]);
        }

        Collections.sort(nums1);
        Collections.sort(nums2);
        Collections.sort(target1);
        Collections.sort(target2);

        int ans = 0;
        for (int i = 0; i < nums1.size(); i++) {
            if (nums1.get(i) > target1.get(i)) ans += (nums1.get(i) - target1.get(i)) / 2;
        }

        for (int i = 0; i < nums1.size(); i++) {
            if (nums2.get(i) > target2.get(i)) ans += (nums2.get(i) - target2.get(i)) / 2;
        }

        return ans;
    }
}