package 代码随想录.回溯算法.子集2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wu
 * @date 2022年09月14日 11:55
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTrack(nums, 0, new ArrayList<>());
        return ans;
    }

    public void backTrack(int[] nums, int idx, List<Integer> path) {
        ans.add(new ArrayList<>(path));
        if (idx == nums.length) return;
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            backTrack(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}