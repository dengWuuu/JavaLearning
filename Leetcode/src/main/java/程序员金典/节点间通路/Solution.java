package 程序员金典.节点间通路;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] ints : graph) {
            int x = ints[0], y = ints[1];
            g.get(x).add(y);
            g.get(y).add(x);
        }
        boolean[] visit = new boolean[n];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        while (!deque.isEmpty()) {
            int pop = deque.pop();

            List<Integer> integers = g.get(pop);
            for (Integer integer : integers) {
                if (visit[integer]) continue;
                visit[integer] = true;
                if (integer == target) return true;
                deque.add(integer);
            }
        }
        return false;
    }
}