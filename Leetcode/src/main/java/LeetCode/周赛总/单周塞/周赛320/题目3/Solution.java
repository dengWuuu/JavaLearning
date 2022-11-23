package LeetCode.周赛总.单周塞.周赛320.题目3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Wu
 * @date 2022年11月20日 9:56
 */
public class Solution {
    public static long minimumFuelCost(int[][] roads, int seats) {
        if (roads.length == 0) return 0;
        int ans = 0, n = roads.length + 1;
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int x = road[0], y = road[1];
            if (y == 0) {
                int tmp = y;
                y = x;
                x = tmp;
            }
            List<Integer> xp = g.get(x);
            xp.add(y);
        }
        System.out.println(g);

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(0);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int point = deque.pop();
                List<Integer> integers = g.get(point);
                for (Integer integer : integers) {
                    deque.addLast(integer);
                    ans += (g.get(integer).size() + 1 + seats) / seats;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minimumFuelCost(new int[][]{{3, 1}, {3, 2}, {1, 0}, {0, 4}, {0, 5}, {4, 6}}, 2));
    }
}