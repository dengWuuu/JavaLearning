package 剑指Offer_专项突击版.图.课程顺序;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    //记录有向图
    List<List<Integer>> edges = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<>());
        }
        int idx = 0;
        int[] ans = new int[numCourses];
        //存储每个节点的入度
        int[] degree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
            degree[prerequisite[0]]++;
        }

        Deque<Integer> deque = new LinkedList<>();
        //把所有为0的入度点入队列
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) deque.add(i);
        }
        if (deque.isEmpty()) {
            return null;
        }
        while (!deque.isEmpty()) {
            int node = deque.poll();
            ans[idx++] = node;
            for (int i = 0; i < edges.get(node).size(); i++) {
                int next = edges.get(node).get(i);
                degree[next]--;
                if (degree[next] == 0) {
                    deque.add(next);
                }
            }
        }
        return idx != numCourses ? new int[]{} : ans;
    }
}