package LeetCode.热题100.组合总和;

import java.util.*;

/**
 * @author Wu
 * @date 2022年08月13日 12:50
 */
public class Solution {
    static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) return ans;
        Arrays.sort(candidates);
        backtrack(candidates, target, new ArrayList<>(), 0);
        return ans;
    }

    public static void backtrack(int[] candidates, int target, List<Integer> tmp, int begin) {
        if (target < 0) return;
        if (target == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (target - candidates[i] < 0) break;
            tmp.add(candidates[i]);
            backtrack(candidates, target - candidates[i], tmp, i);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        combinationSum(new int[]{2, 3, 6, 7}, 7);
    }
}
