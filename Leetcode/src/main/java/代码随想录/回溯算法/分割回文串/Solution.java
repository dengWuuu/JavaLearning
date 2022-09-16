package 代码随想录.回溯算法.分割回文串;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年09月14日 10:53
 */
public class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backTrack(s, 0, new ArrayList<>());
        return ans;
    }

    public void backTrack(String s, int idx, List<String> path) {
        if (idx >= s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (isPartition(s, idx, i)) {
                path.add(s.substring(idx, i + 1));
            } else continue;
            backTrack(s, i + 1, path);
            path.remove(path.size() - 1);
        }
    }

    public boolean isPartition(String s, int left, int right) {
        for (int i = left, j = right; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}
