package LeetCode.周赛总.单周塞.周赛337.题3;

import java.util.*;

class Solution {
    int[] nums;
    int k;
    boolean[] visited;
    int ans = 0;

    public int beautifulSubsets(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
        visited = new boolean[nums.length];
        dfs(0, new ArrayList<>());
        return ans;
    }

    public void dfs(int idx, List<Integer> path) {

        for (int i = idx; i < nums.length; i++) {
            if (visited[i]) continue;
            boolean f = false;
            for (Integer num : path) {
                if (Math.abs(nums[i] - nums[num]) == k) {
                    f = true;
                    break;
                }
            }
            if (f) continue;
            visited[i] = true;
            path.add(i);
            ans++;
            dfs(i + 1, path);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}