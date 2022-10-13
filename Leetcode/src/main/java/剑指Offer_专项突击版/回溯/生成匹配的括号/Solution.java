package 剑指Offer_专项突击版.回溯.生成匹配的括号;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年10月13日 9:23
 */
public class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0, "");
        return ans;
    }
    public void dfs(int n, int left, int right, String s) {
        if (left == right && left + right == 2 * n) {
            ans.add(s);
            return;
        }
        if (right > left || left > n || right > n) return;
        dfs(n, left + 1, right, s + "(");
        dfs(n, left, right + 1, s + ")");
    }
}