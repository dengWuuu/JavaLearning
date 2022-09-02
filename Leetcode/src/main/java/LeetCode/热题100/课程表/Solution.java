package LeetCode.热题100.课程表;

import java.util.*;

/**
 * https://leetcode.cn/problems/course-schedule/
 *
 * @author Wu
 * @date 2022年08月28日 8:10
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indices = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) adjacency.add(new ArrayList<>());

        //初始化入度
        for (int[] prerequisite : prerequisites) {
            indices[prerequisite[0]]++;
            adjacency.get(prerequisite[1]).add(prerequisite[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (indices[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int num = queue.poll();
            numCourses--;
            List<Integer> integers = adjacency.get(num);
            for (Integer integer : integers) {
                indices[integer]--;
                if (indices[integer] == 0) queue.add(integer);
            }
        }
        return numCourses == 0;
    }

    public static void main(String[] args) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
    }
}
