package LeetCode.周赛总.单周塞.周赛337.题3;

import java.util.*;

class Solution {

    Set<String> set = new HashSet<>();
    int[] nums;
    int k;
    boolean[] visited;

    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        this.nums = nums;
        this.k = k;
        visited = new boolean[nums.length];
        int ans = (int) Math.pow(2, nums.length) - 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    dfs(i, j, new StringBuilder());
                } else if (Math.abs(nums[i] - nums[j]) > k) break;
            }
        }
        System.out.println(set);
        return ans - set.size();
    }

    public void dfs(int i, int j, StringBuilder path) {
    }
}