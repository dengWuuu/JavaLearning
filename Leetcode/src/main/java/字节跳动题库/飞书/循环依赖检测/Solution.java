package 字节跳动题库.飞书.循环依赖检测;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Wu
 * @date 2022年10月26日 12:00
 */
public class Solution {
    static List<List<Integer>> edges;

    public static boolean hasCircle(int[][] graph) {
        edges = new ArrayList<>();
        int n = graph.length;
        int[] degree = new int[n];

        for (int i = 0; i < n; i++) {
            edges.add(i, new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            List<Integer> integers = edges.get(i);
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] == 1) {
                    integers.add(j);
                    degree[j]++;
                }
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) queue.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            ans.add(poll);
            List<Integer> integers = edges.get(poll);
            for (Integer integer : integers) {
                degree[integer]--;
                if (degree[integer] == 0) queue.add(integer);
            }

        }
        return ans.size() == n;
    }

    public static void main(String[] args) {
        System.out.println(hasCircle(new int[][]{{0, 1, 0}, {0, 0, 0}, {1, 0, 0}}));
    }
}
