package LeetCode.周赛总.单周塞.周赛338.题4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < coins.length; i++) {
            g.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
        }
        return 0;
    }
}