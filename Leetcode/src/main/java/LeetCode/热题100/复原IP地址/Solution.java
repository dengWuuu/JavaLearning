package LeetCode.热题100.复原IP地址;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年08月22日 15:31
 */
public class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backTrack(s, 0, 0, new StringBuilder());
        return ans;
    }

    private void backTrack(String s, int idx, int pointNum, StringBuilder path) {
        if (idx == s.length() && pointNum == 4) {
            ans.add(path.toString());
            return;
        }
        if (s.length() == idx || pointNum == 4) return;

        for (int i = idx; i < s.length()
                && i - idx < 3
                && Integer.parseInt(s.substring(idx, i + 1)) >= 0
                && Integer.parseInt(s.substring(idx, i + 1)) <= 255; i++) {
            if (i - idx > 0 && s.charAt(idx) == '0') continue;
            path.append(s, idx, i + 1);
            if (pointNum < 3) path.append(".");
            pointNum++;
            backTrack(s, i + 1, pointNum, path);
            pointNum--;
            //删除最后一个点之后的数字,
            path.delete(idx + pointNum, 15);
        }
    }
}
