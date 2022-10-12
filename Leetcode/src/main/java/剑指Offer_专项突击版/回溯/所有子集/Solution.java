package 剑指Offer_专项突击版.回溯.所有子集;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年10月12日 10:46
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backTrack(nums, new ArrayList<>(), 0);
        return ans;
    }

    public void backTrack(int[] nums, List<Integer> path, int idx){

    }
}