package LeetCode.周赛总.单周塞.周赛324.题3;

import java.util.*;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
public class Solution {
    public static boolean isPossible(int n, List<List<Integer>> edges) {
        List<Set<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            g.add(new HashSet<>());
        }
        for (List<Integer> edge : edges) {
            int x = edge.get(0);
            int y = edge.get(1);
            g.get(x).add(y);
            g.get(y).add(x);
        }
        int num = 0;
        List<Integer> nums = new ArrayList<>();

        for (int i = 1; i < g.size(); i++) {
            if (g.get(i).size() % 2 != 0) {
                num++;
                nums.add(i);
            }
        }
        if (num % 2 != 0 || num > 4) return false;
        else if (num == 0) return true;

        if (num == 2) {
            System.out.println(2);
            if (!g.get(nums.get(0)).contains(nums.get(1))) return true;
            Set<Integer> set1 = g.get(nums.get(0));
            Set<Integer> set2 = g.get(nums.get(1));
            for (int i = 1; i < n + 1; i++) {
                if (nums.get(0) != i && nums.get(1) != i && !set1.contains(i) && !set2.contains(i)) return true;
            }
        } else if (num == 4) {
            System.out.println(4);
            if (!g.get(nums.get(0)).contains(nums.get(1)) && !g.get(nums.get(2)).contains(nums.get(3))) return true;
            if (!g.get(nums.get(0)).contains(nums.get(2)) && !g.get(nums.get(1)).contains(nums.get(3))) return true;
            if (!g.get(nums.get(0)).contains(nums.get(3)) && !g.get(nums.get(1)).contains(nums.get(2))) return true;
        }
        return false;
    }
}