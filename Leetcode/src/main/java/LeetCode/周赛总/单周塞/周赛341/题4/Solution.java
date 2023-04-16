package LeetCode.周赛总.单周塞.周赛341.题4;

import java.util.*;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
class Solution {
    int[] cnt;
    List<List<Integer>> g = new ArrayList<>();
    int[] price;

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        this.price = price;
        for (int[] edge : edges) {
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
        }
        cnt = new int[n];
        for (int[] trip : trips) {
            dfs(trip[0], trip[1], -1);
        }
        int[] p = dfs(0, -1);
        return Math.min(p[0], p[1]);
    }

    public boolean dfs(int x, int end, int f) {
        if (x == end) {
            cnt[x]++;
            return true;
        }
        for (int p : g.get(x)) {
            if (p != f && dfs(p, end, x)) {
                cnt[x]++;
                return true;
            }
        }
        return false;
    }

    // 类似 337. 打家劫舍 III https://leetcode.cn/problems/house-robber-iii/
    private int[] dfs(int x, int fa) {
        int notHalve = price[x] * cnt[x]; // x 不变
        int halve = notHalve / 2; // x 减半
        for (int y : g.get(x))
            if (y != fa) {
                int[] p = dfs(y, x); // 计算 y 不变/减半的最小价值总和
                notHalve += Math.min(p[0], p[1]); // x 不变，那么 y 可以不变，可以减半，取这两种情况的最小值
                halve += p[0]; // x 减半，那么 y 只能不变
            }
        return new int[]{notHalve, halve};
    }
}