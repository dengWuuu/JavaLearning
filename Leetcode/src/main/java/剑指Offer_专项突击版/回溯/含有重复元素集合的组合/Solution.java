package 剑指Offer_专项突击版.回溯.含有重复元素集合的组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wu
 * @date 2022年10月12日 11:27
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates, target, 0, new ArrayList<>());
        return ans;
    }

    public void backTrack(int[] candidates, int target, int idx, List<Integer>path){
        if(target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = idx; i < candidates.length; i++){
            if(i > idx && candidates[i] == candidates[i - 1]) continue;
            if(candidates[i] > target) return;
            path.add(candidates[i]);
            backTrack(candidates,target - candidates[i], i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}