package 剑指Offer_专项突击版.二叉树.值和下标之差都在给定的范围内;

import java.util.TreeSet;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer small = set.floor(nums[i]);
            if (small != null && (long) small >= (long) nums[i] - t) return true;
            Integer big = set.ceiling(nums[i]);
            if (big != null && (long) big <= (long) nums[i] + t) return true;
            set.add(nums[i]);
            if (i >= k) set.remove(nums[i - k]);
        }
        return false;
    }
}