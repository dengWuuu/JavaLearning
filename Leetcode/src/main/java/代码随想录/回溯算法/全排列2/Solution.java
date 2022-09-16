package 代码随想录.回溯算法.全排列2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wu
 * @date 2022年09月14日 19:12
 */
public class Solution {
    boolean[] visited;
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        backTrack(nums, nums.length, new ArrayList<>());
        return ans;
    }
    public void backTrack(int[] nums, int length, List<Integer> path) {
        if (length == 0) ans.add(new ArrayList<>(path));
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) continue;
            path.add(nums[i]);
            visited[i] = true;
            backTrack(nums, length - 1, path);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}