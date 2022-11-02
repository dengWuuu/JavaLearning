package 字节跳动题库.括号生成;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年11月02日 15:41
 */
public class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backTrack(n, 0, 0, new StringBuilder());
        return ans;
    }

    public void backTrack(int n, int l, int r, StringBuilder sb) {
        if (r > l) return;
        if (l + r == 2 * n) {
            ans.add(sb.toString());
            return;
        }

        if (l == r) {
            sb.append('(');
            backTrack(n, l + 1, r, sb);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            if (l < n) {
                sb.append('(');
                backTrack(n, l + 1, r, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(')');
            backTrack(n, l, r + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}