package 剑指Offer_专项突击版.回溯.允许重复选择元素的组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wu
 * @date 2022年10月12日 11:12
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates, target, new ArrayList<>(), 0);
        return ans;
    }

    public void backTrack(int[] candidates, int target, List<Integer>path, int idx){
        if(target < 0) return;
        if(target == 0) ans.add(new ArrayList<>(path));
        for(int i = idx; i < candidates.length; i++){
            if(candidates[i] > target) return;
            path.add(candidates[i]);
            backTrack(candidates, target - candidates[i], path, i);
            path.remove(path.size() - 1);
        }
    }
}
