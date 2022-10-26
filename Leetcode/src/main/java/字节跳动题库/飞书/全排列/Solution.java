package 字节跳动题库.飞书.全排列;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年10月26日 11:34
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        backTrack(nums, new ArrayList<>());
        return ans;
    }


    public void backTrack(int[] nums, List<Integer> path) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            path.add(nums[i]);
            backTrack(nums, path);
            path.remove(path.size() - 1);
            visited[i] = false;
        }

    }
}