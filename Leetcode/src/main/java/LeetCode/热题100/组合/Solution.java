package LeetCode.热题100.组合;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年08月19日 12:06
 */
public class Solution {
    static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        dfs(n, k, new ArrayList<>(), 1);
        return ans;
    }

    public static void backTrack(int n, int k, List<Integer> path, int index) {
        if (k == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i <= n; i++) {
            path.add(i);
            backTrack(n, k - 1, path, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void dfs(int n, int k, List<Integer> path, int idx) {
        if (k == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (idx > n - k + 1){
            return;
        }

        dfs(n, k, path, idx + 1);
        path.add(idx);
        dfs(n, k - 1, path, idx + 1);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }
}
