package 代码随想录.回溯算法.递增子序列;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年09月14日 11:56
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();


    public List<List<Integer>> findSubsequences(int[] nums) {
        backTrack(nums, 0, new ArrayList<>());
        return ans;
    }

    public void backTrack(int[] nums, int idx, List<Integer> path) {
        if (path.size() > 1) ans.add(new ArrayList<>(path));
        boolean[] used = new boolean[201];
        for (int i = idx; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) || used[nums[i] + 100]) continue;
            used[nums[i] + 100] = true;
            path.add(nums[i]);
            backTrack(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
