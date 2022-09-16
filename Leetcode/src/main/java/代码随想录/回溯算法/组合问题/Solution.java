package 代码随想录.回溯算法.组合问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年09月12日 14:25
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTrack(n, k, 1, new ArrayList<>());
        return ans;
    }

    public void backTrack(int n, int k, int idx, List<Integer> path) {
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backTrack(n, k, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
