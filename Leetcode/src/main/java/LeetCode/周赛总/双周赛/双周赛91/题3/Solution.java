package LeetCode.周赛总.双周赛.双周赛91.题3;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        List<List<Integer>> edge = new ArrayList<>();
        for (int i = 0; i <= edges.length; i++) {
            edge.add(new ArrayList<>());
        }
        for (int[] ints : edges) {
            int x = ints[0], y = ints[1];
            List<Integer> integers = edge.get(x);
            integers.add(y);
        }
        int ans = amount[0];




        return ans;
    }
}