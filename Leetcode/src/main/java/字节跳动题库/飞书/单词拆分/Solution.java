package 字节跳动题库.飞书.单词拆分;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Wu
 * @date 2022年10月26日 14:38
 */
public class Solution {
    Set<String> set;
    int[] memory;

    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        memory = new int[s.length()];
        return dfs(s, 0);
    }


    public boolean dfs(String s, int idx) {
        if (idx == s.length()) return true;
        if (memory[idx] == -1) return false;
        for (int i = idx; i < s.length(); i++) {
            if (set.contains(s.substring(idx, i + 1))) {
                boolean dfs = dfs(s, i + 1);
                if (dfs) return true;
            }
        }
        memory[idx] = -1;
        return false;
    }
}
