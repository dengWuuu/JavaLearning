package 代码随想录.回溯算法.组合总和;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年09月13日 19:39
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int sum = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(candidates, target, 0, new ArrayList<>());
        return ans;
    }
    public void backTrack(int[] candidates, int target, int idx, List<Integer> path) {
        if (sum > target) return;
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            backTrack(candidates, target, i, path);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
