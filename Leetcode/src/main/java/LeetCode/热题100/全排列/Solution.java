package LeetCode.热题100.全排列;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年08月15日 10:58
 */
public class Solution {
    static boolean[] visit;
    static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        visit = new boolean[nums.length];
        backTrack(nums, nums.length, new ArrayList<>());
        return ans;
    }

    public static void backTrack(int[] nums, int length, List<Integer> path) {
        if (length == 0) ans.add(new ArrayList<>(path));
        for (int i = 0; i < nums.length; i++) {
            if (!visit[i]) {
                path.add(nums[i]);
                visit[i] = true;
                backTrack(nums, length - 1, path);
                visit[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
