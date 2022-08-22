package LeetCode.热题100.子集II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wu
 * @date 2022年08月22日 11:55
 */
public class Solution {
    static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTrack(nums, 0, new ArrayList<>());
        return ans;
    }

    public static void backTrack(int[] nums, int idx, List<Integer> path) {
        ans.add(new ArrayList<>(path));
        if (idx == nums.length) return;
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            backTrack(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1, 2, 2}));
    }
}
