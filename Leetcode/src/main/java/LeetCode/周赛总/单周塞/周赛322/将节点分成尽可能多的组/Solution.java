package LeetCode.周赛总.单周塞.周赛322.将节点分成尽可能多的组;

import java.util.*;

public class Solution {
    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            g.add(new ArrayList<>());
        }
        int[] degree = new int[n + 1];
        int ans = 0;
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            degree[x]++;
            degree[y]++;
            g.get(x).add(y);
            g.get(y).add(x);
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i < degree.length; i++) {
            if (degree[i] == 0) ans++;
        }
        int min = Integer.MAX_VALUE;
        int idx = 1;
        for (int i = 1; i < degree.length; i++) {
            if (degree[i] < min) {
                min = degree[i];
                idx = i;
            }
        }
        deque.add(idx);

        boolean[] visit = new boolean[n + 1];
        int[] is = new int[n + 1];
        int fen = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Integer poll = deque.pollFirst();
                if (visit[poll]) continue;
                is[poll] = fen;
                visit[poll] = true;
                List<Integer> list = g.get(poll);
                for (Integer integer : list) {
                    if (is[integer] == 0) {
                        deque.addLast(integer);
                        continue;
                    }
                    if (Math.abs(fen - is[integer]) > 1) return -1;
                }
            }
            fen++;
            ans++;
        }
        return ans;
    }
}
