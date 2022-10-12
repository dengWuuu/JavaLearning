package 剑指Offer_专项突击版.回溯.含有k个元素的组合;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年10月12日 10:57
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backTrack(n, k, new ArrayList<>(), 1);
        return ans;
    }

    public void backTrack(int n, int k, List<Integer>path, int idx){
        if(path.size() == k) ans.add(new ArrayList<>(path));
        if(path.size() + (n - idx) + 1 < k) return;
        for(int i = idx; i <= n; i++){
            if(path.size() < k){
                path.add(i);
                backTrack(n,k,path,i+1);
                path.remove(path.size() - 1);
            }else{
                return;
            }
        }
    }
}