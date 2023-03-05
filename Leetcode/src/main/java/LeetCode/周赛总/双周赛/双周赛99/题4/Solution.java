package LeetCode.周赛总.双周赛.双周赛99.题4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年12月10日 22:16
 */

public class Solution {
    List<List<Integer>> g = new ArrayList<>();

    public int rootCount(int[][] edges, int[][] guesses, int k) {
        int ans = 0;
        int n = edges.length + 1;
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            g.get(x).add(y);
            g.get(y).add(x);
        }

        


        return ans;
    }
}