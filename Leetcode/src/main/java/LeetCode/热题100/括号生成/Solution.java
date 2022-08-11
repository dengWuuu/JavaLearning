package LeetCode.热题100.括号生成;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Wu
 * @date 2022年08月10日 15:20
 */
public class Solution {
    static List<String> ans = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        if (n == 0) return ans;
        backtrack(new StringBuilder(), n, n);
        return ans;
    }

    static void backtrack(StringBuilder sb, int left, int right) {
        if (left == 0 && right == 0) {
            ans.add(sb.toString());
            return;
        }

        if (left == right) {
            sb.append('(');
            backtrack(sb, left - 1, right);
            sb.deleteCharAt(sb.length() - 1);
        } else if (left < right) {
            if (left > 0) {
                sb.append('(');
                backtrack(sb, left - 1, right);
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(')');
            backtrack(sb, left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
