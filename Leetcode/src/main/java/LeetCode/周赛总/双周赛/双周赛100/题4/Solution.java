package LeetCode.周赛总.双周赛.双周赛100.题4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Wu
 * @date 2022年12月10日 22:16
 */

public class Solution {
    Set<String> set = new HashSet<>();
    int cnt0 = 0;
    int ans = 0;
    List<List<Integer>> g = new ArrayList<>();
    int k;

    public int rootCount(int[][] edges, int[][] guesses, int k) {
        this.k = k;
        for (int i = 0; i < edges.length + 1; i++) {
            g.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            g.get(x).add(y);
            g.get(y).add(x);
        }

        for (int[] guess : guesses) {
            set.add(guess[0] + "_" + guess[1]);
        }
        dfs(0, -1);
        reroot(0, -1, cnt0);
        return ans;
    }

    public void dfs(int i, int f) {
        for (int p : g.get(i)) {
            if (p != f) {
                if (set.contains(i + "_" + p)) cnt0++;
                dfs(p, i);
            }
        }
    }

    public void reroot(int i, int f, int cnt) {
        if (cnt >= k) ans++;
        for (int p : g.get(i))
            if (p != f) {
                int c = cnt;
                if (set.contains(i + "_" + p)) --c;
                if (set.contains(p + "_" + i)) ++c;
                reroot(p, i, c);
            }
    }
}