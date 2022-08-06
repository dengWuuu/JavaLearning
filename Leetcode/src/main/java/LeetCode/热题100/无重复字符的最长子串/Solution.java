package LeetCode.热题100.无重复字符的最长子串;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wu
 * @date 2022年08月06日 16:37
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> hashSet = new HashSet<>();
        int n = s.length();
        if (n == 0 || n == 1) return n;
        int left, right;
        int ans = 0;
        for (left = 0, right = 0; right < n; right++) {
            char cur = s.charAt(right);
            if (hashSet.contains(cur)) {
                while (hashSet.contains(cur)) {
                    hashSet.remove(s.charAt(left++));
                }
            }
            hashSet.add(cur);
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}