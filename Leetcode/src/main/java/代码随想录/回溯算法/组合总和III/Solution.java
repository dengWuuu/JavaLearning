package 代码随想录.回溯算法.组合总和III;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年09月13日 18:48
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTrack(k, n, 1, new ArrayList<>());
        return ans;
    }

    public void backTrack(int k, int n, int idx, List<Integer> path) {
        if (sum > n) return;
        if (path.size() == k) {
            if (n == sum) ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i <= 9; i++) {
            path.add(i);
            sum += i;
            backTrack(k, n, i + 1, path);
            sum -= i;
            path.remove(path.size() - 1);
        }
    }
}
