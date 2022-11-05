package 字节跳动题库.复原IP地址;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backTrack(s, 0, 0, new StringBuilder());
        return ans;
    }

    public void backTrack(String s, int idx, int point, StringBuilder path) {
        if (point == 4 && idx == s.length()) {
            ans.add(path.toString());
            return;
        }
        if (s.length() == idx || point == 4) return;

        for (int i = idx; i < s.length()
                && Integer.parseInt(s.substring(idx, i + 1)) <= 255
                && Integer.parseInt(s.substring(idx, i + 1)) >= 0
                && i - idx <= 2; i++) {
            if (i > idx && s.charAt(idx) == '0') continue;

            path.append(s, idx, i + 1);
            if (point < 3) path.append(".");
            point++;
            backTrack(s, i + 1, point, path);
            point--;
            path.delete(idx + point, 15);
        }

    }
}