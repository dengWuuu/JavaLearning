package 代码随想录.回溯算法.组合总和II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wu
 * @date 2022年09月13日 19:57
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates, target, 0, new ArrayList<>());
        return ans;
    }

    public void backTrack(int[] candidates, int target, int idx, List<Integer> path) {
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < candidates.length && sum + candidates[i] <= target; i++) {
            if (i > idx && candidates[i - 1] == candidates[i]) continue;
            sum += candidates[i];
            path.add(candidates[i]);
            backTrack(candidates, target, i + 1, path);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}