package LeetCode.周赛总.单周塞.周赛322.两个城市之间的最小得分路径;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class Solution {
    public static int minScore(int n, int[][] roads) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        g.add(new ArrayList<>());
        for (int[] road : roads) {
            int x = road[0];
            int y = road[1];
            g.get(x).add(y);
            g.get(y).add(x);
        }

        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] flag = new boolean[n + 1];
        boolean[] visit = new boolean[n + 1];
        deque.add(1);
        while (!deque.isEmpty()) {
            int poll = deque.poll();
            if (visit[poll]) continue;
            visit[poll] = true;
            List<Integer> list = g.get(poll);
            for (Integer integer : list) {
                flag[integer] = true;
                deque.add(integer);
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int[] road : roads) {
            if (flag[road[0]] && flag[road[1]]) {
                ans = Math.min(ans, road[2]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minScore(4, new int[][]{{1, 2, 9}, {2, 3, 6}, {2, 4, 5}, {1, 4, 7}}));
    }
}