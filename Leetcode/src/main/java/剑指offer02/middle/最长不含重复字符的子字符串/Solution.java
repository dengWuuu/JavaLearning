package 剑指offer02.middle.最长不含重复字符的子字符串;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wu
 * @date 2022年08月02日 12:04
 */
public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (s.equals(" ")) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        int ans = 0;
        char[] chars = s.toCharArray();
        int l = 0, r = 0;
        Set<Character> hashSet = new HashSet<>();
        while (r < n) {
            if (hashSet.contains(chars[r])) {
                while (hashSet.contains(chars[r])) hashSet.remove(chars[l++]);
            }
            hashSet.add(chars[r]);
            r++;
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}