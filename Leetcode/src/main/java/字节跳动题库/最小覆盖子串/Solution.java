package 字节跳动题库.最小覆盖子串;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年11月02日 16:57
 */
public class Solution {

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }
        int dis = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() < 0) dis++;
        }
        if (dis == 0) return s.substring(0, t.length());

        int minLen = Integer.MAX_VALUE, ansL = -1, left = 0;
        for (int i = t.length(); i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) == 0) dis--;
            if (dis != 0) continue;
            while (dis == 0) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if (map.get(s.charAt(left)) == -1) dis++;
                left++;
            }
            if (i - left + 2 < minLen) {
                ansL = left - 1;
                minLen = i - left + 2;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansL + minLen);
    }
}