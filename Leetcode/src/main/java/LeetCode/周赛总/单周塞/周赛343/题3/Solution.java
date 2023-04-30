package LeetCode.周赛总.单周塞.周赛343.题3;


import java.util.*;

/**
 * @author Wu
 * @date 2023年4月30日 10:21
 */

class Solution {
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        int res = dist(start, target);
        pq.offer(new int[]{start[0], start[1], 0});
        Map<String, Integer> vis = new HashMap<>();
        vis.put(getKey(start), 0);
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            for (int[] sp : specialRoads) {
                int[] p1 = new int[]{sp[0], sp[1]};
                int[] p2 = new int[]{sp[2], sp[3]};
                int d = p[2] + dist(p, p1) + sp[4];
                String key = getKey(p2);
                int x = vis.getOrDefault(key, dist(start, p2));
                if (d < x) {
                    vis.put(key, d);
                    pq.offer(new int[]{p2[0], p2[1], d});
                    res = Math.min(res, d + dist(p2, target));
                }
            }
        }
        return res;
    }

    private int dist(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    private String getKey(int[] p) {
        return p[0] + "-" + p[1];
    }
}