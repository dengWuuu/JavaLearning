package 剑指Offer_专项突击版.字符串.不含重复字符的最长子字符串;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wu
 * @date 2022年09月28日 19:00
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, len = 0;
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                len = Math.max(len, right - left + 1);
                right++;
            } else {
                while (set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left));
                    left++;
                }
            }
        }
        return len;
    }
}
