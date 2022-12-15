package LeetCode.周赛总.双周赛.双周赛93.题2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Wu
 * @date 2022年12月10日 22:16
 */
public class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int n = vals.length;
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];

            g.get(x).add(vals[y]);
            g.get(y).add(vals[x]);
        }
        int idx = 0;
        int ans = Integer.MIN_VALUE;
        for (List<Integer> list : g) {
            Collections.sort(list);
            int sum = vals[idx++];
            int d = k;
            for (int i = list.size() - 1; i >= 0; i--) {
                if (list.get(i) < 0) break;
                sum += list.get(i);
                d--;
                if (d == 0) break;
            }
            ans = Math.max(ans, sum);

        }
        return ans;

    }
}