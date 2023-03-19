package LeetCode.周赛总.单周塞.周赛336.题4;

import java.util.*;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
public class Solution {
    public static int findMinimumTime(int[][] tasks) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(tasks, Comparator.comparingInt(x -> x[0]));

        for (int i = 0; i < tasks.length; i++) {
            for (int j = tasks[i][0]; j <= tasks[i][1]; j++) {
                if (map.containsKey(j)) {
                    int idx = -1;
                    int max = -1;
                    for (int k = 0; k < tasks.length; k++) {
                        if (tasks[i][0] <= j && tasks[i][1] >= j && tasks[i][2] > 0) {
                            if (tasks[i][2] > max) {
                                max = tasks[i][2];
                                idx = k;
                            }
                        }
                    }
                    map.put(j, map.get(j) - 1);
                    ans++;
                }
            }
        }
        for (int[] task : tasks) {
            ans += task[2];
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(findMinimumTime(new int[][]{{2, 13, 2}, {6, 18, 5}, {2, 13, 3}}));
        System.out.println(findMinimumTime(new int[][]{{14, 20, 5}, {2, 18, 7}, {6, 14, 1}, {3, 16, 3}}));
    }
}