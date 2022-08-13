package LeetCode.热题100.组合总和II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wu
 * @date 2022年08月13日 13:21
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) return ans;
        Arrays.sort(candidates);
        backtrack(candidates, target, new ArrayList<>(), 0);
        return ans;
    }

    public void backtrack(int[] candidates, int target, List<Integer> path, int index) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) break;
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
