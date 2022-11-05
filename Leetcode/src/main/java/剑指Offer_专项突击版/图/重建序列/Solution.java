package 剑指Offer_专项突击版.图.重建序列;

import java.util.*;

public class Solution {
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        List<List<Integer>> edges = new ArrayList<>();
        int[] degree = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            edges.add(new ArrayList<>());
        }
        //计算入度和构建有向无权图
        for (int[] sequence : sequences) {
            for (int i = 0; i < sequence.length - 1; i++) {
                degree[sequence[i + 1] - 1]++;
                List<Integer> integers = edges.get(sequence[i] - 1);
                integers.add(sequence[i + 1] - 1);
            }
        }

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) deque.add(i);
        }

        if (deque.size() != 1) return false;
        int idx = 0;
        int[] ans = new int[nums.length];
        while (!deque.isEmpty()) {
            int node = deque.poll();
            List<Integer> nodeList = edges.get(node);
            for (Integer integer : nodeList) {
                degree[integer]--;
                if (degree[integer] == 0) {
                    deque.add(integer);
                }
            }
            if (deque.size() > 1) return false;
            ans[idx++] = node;
        }

        return Arrays.equals(ans, nums);

    }
}