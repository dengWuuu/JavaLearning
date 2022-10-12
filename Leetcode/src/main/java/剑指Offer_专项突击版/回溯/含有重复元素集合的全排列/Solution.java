package 剑指Offer_专项突击版.回溯.含有重复元素集合的全排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wu
 * @date 2022年10月12日 22:19
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] visit;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        visit = new boolean[nums.length];
        backTrack(nums, new ArrayList<>());
        return ans;
    }

    public void backTrack(int[] nums, List<Integer>path){
        if(path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0 ; i < nums.length; i++){
            if(visit[i]) continue;
            if(i > 0 && nums[i] == nums[i-1] && !visit[i - 1]) continue;
            visit[i] = true;
            path.add(nums[i]);
            backTrack(nums, path);
            path.remove(path.size() - 1);
            visit[i] = false;
        }
    }
}