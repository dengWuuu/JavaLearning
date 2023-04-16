package LeetCode.周赛总.单周塞.周赛341.题4;

import java.util.*;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
class Solution {
    boolean[] visit;

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
        }

        int[][] nPrice = new int[n][n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            nPrice[idx++] = divide(i, g, price);
        }
        int cnt = Integer.MAX_VALUE;
        for (int i = 0; i < nPrice.length; i++) {
            cnt = Math.min(cnt, getMin(nPrice[i], g, trips));
        }
        return cnt;
    }

    List<Integer> path;

    public int getMin(int[] price, List<List<Integer>> g, int[][] trips) {
        int cnt = 0;
        for (int[] trip : trips) {
            int source = trip[0];
            int target = trip[1];
            visit = new boolean[price.length];
            visit[source] = true;
            path = new ArrayList<>();
            path.add(source);
            dfs(g, source, target);
            for (int p : path) {
                cnt += price[p];
            }
        }
        return cnt;
    }

    public void dfs(List<List<Integer>> g, int source, int target) {
        if (source == target) {
            return;
        }
        for (int p : g.get(source)) {
            if (visit[p]) continue;
            visit[p] = true;
            path.add(p);
            dfs(g, p, target);
            if (path.get(path.size() - 1) == target) break;
            path.remove(path.size() - 1);
            visit[p] = false;
        }
    }

    public int[] divide(int p, List<List<Integer>> g, int[] price) {
        int[] newPrice = new int[price.length];
        boolean[] visited = new boolean[price.length];
        visited[p] = true;
        System.arraycopy(price, 0, newPrice, 0, price.length);
        Deque<Integer> d = new ArrayDeque<>();
        d.add(p);
        int cnt = 0;
        while (!d.isEmpty()) {
            int size = d.size();
            for (int i = 0; i < size; i++) {
                int poll = d.poll();
                if (cnt % 2 == 0) {
                    newPrice[poll] /= 2;
                }
                for (Integer integer : g.get(poll)) {
                    if (visited[integer]) continue;
                    d.add(integer);
                    visited[integer] = true;
                }
            }
            cnt++;
        }
        return newPrice;
    }
}