package 剑指offer02.middle.字符串的排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wu
 * @date 2022年07月30日 22:42
 */
public class Solution2 {
    int N = 10;
    List<String> list = new ArrayList<>();
    boolean[] vis = new boolean[N];
    public String[] permutation(String s) {
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        dfs(cs, 0, "");
        String[] ans = new String[list.size()];
        int idx = 0;
        for (String str : list) ans[idx++] = str;
        return ans;
    }
    void dfs(char[] cs, int u, String cur) {
        int n = cs.length;
        if (u == n) {
            list.add(cur);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (i > 0 && !vis[i - 1] && cs[i] == cs[i - 1]) continue;
            if (!vis[i]) {
                vis[i] = true;
                dfs(cs, u + 1, cur + String.valueOf(cs[i]));
                vis[i] = false;
            }
        }
    }
}

