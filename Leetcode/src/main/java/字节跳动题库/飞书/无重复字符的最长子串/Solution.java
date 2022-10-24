package 字节跳动题库.飞书.无重复字符的最长子串;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Wu
 * @date 2022年10月24日 20:07
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        Set<Character> set = new HashSet<>();
        int l = 0, r = 1;
        int ans = 1;
        set.add(s.charAt(l));
        while (r < s.length()) {
            if (set.contains(s.charAt(r))) {
                while (set.contains(s.charAt(r))) {
                    set.remove(s.charAt(l));
                    l++;
                }
            }
            ans = Math.max(ans, r - l + 1);
            set.add(s.charAt(r));
            r++;
        }
        return ans;
    }
}
