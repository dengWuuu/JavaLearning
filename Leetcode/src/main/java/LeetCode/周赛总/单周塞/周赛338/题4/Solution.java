package LeetCode.周赛总.单周塞.周赛338.题4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        List<List<Integer>> g = new ArrayList<>();
        int n = coins.length;
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        int[] cnt = new int[n];
        for (int[] edge : edges) {
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
            cnt[edge[0]]++;
            cnt[edge[1]]++;
        }

        int edgeNums = n - 1;
        Deque<Integer> d = new ArrayDeque<>();
        //找寻没有金币的叶子节点并且删除
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] == 0 && cnt[i] == 1) {
                d.add(i);
            }
        }
        while (!d.isEmpty()) {
            int p = d.poll();
            edgeNums--;
            for (int point : g.get(p)) {
                cnt[point]--;
                if (cnt[point] == 1 && coins[point] == 0) d.add(point);
            }
        }

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] == 1 && cnt[i] == 1) {
                d.add(i);
            }
        }
        edgeNums -= d.size();
        for (int p : d) {
            for (int y : g.get(p)) {
                cnt[y]--;
                if (cnt[y] == 1) edgeNums--;
            }
        }
        return edgeNums >= 0 ? edgeNums * 2 : 0;
    }
}