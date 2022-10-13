package 剑指Offer_专项突击版.回溯.复原IP;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年10月13日 9:44
 */
public class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backTrack(s, 0, 0, new StringBuilder());
        return ans;
    }

    public void backTrack(String s, int idx, int point, StringBuilder sb) {
        if (point == 4 && idx == s.length()) {
            ans.add(sb.substring(0, sb.length() - 1));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (i - idx < 3 && Integer.parseInt(s.substring(idx, i + 1)) <= 255 && Integer.parseInt(s.substring(idx, i + 1)) >= 0) {
                if (i - idx > 0 && s.charAt(idx) == '0') continue;
                sb.append(s, idx, i + 1).append(".");
                point++;
                backTrack(s, i + 1, point, sb);
                point--;
                sb.delete(idx + point, 15);
            }
        }
    }
}