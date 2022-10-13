package 剑指Offer_专项突击版.回溯.分割回文子字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年10月13日 9:29
 */
public class Solution {
    List<List<String>> ans = new ArrayList<>();
    public String[][] partition(String s) {
        backTrack(s, 0, new ArrayList<>());
        String[][] resArr = new String[ans.size()][];
        for (int i = 0; i < ans.size(); i++) {
            List<String> list = ans.get(i);
            resArr[i] = list.toArray(new String[0]);
        }
        return resArr;
    }

    public void backTrack(String s, int idx, List<String> path) {
        if (idx >= s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            if (isValid(s, idx, i)) {
                path.add(s.substring(idx, i + 1));
            }
            backTrack(s, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
    public boolean isValid(String s, int l, int r) {
        for (int i = l, j = r; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}