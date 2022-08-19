package LeetCode.热题100.子集;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年08月19日 12:40
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backTrack(nums, 0, new ArrayList<>());
        return ans;
    }

    public void backTrack(int[] nums, int idx, List<Integer> path) {
        ans.add(new ArrayList<>(path));
        for (int i = idx; i < nums.length; i++) {
            path.add(nums[i]);
            backTrack(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
