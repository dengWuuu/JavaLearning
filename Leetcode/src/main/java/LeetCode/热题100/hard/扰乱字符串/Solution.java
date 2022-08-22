package LeetCode.热题100.hard.扰乱字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年08月21日 11:38
 */
public class Solution {
    static Map<String, Boolean> memory = new HashMap<>();

    public static boolean isScramble(String s1, String s2) {
        String key = s1 + s2;
        if (memory.containsKey(key)) return memory.get(key);
        if (s1.equals(s2)) {
            memory.put(key, true);
            return true;
        }
        int m = s1.length(), n = s2.length();
        if (m != n) return false;
        if (!check(s1, s2)) return false;
        for (int i = 1; i < s1.length(); i++) {
            String a = s1.substring(0, i), b = s1.substring(i);
            String c = s2.substring(0, i), d = s2.substring(i);
            String e = s2.substring(0, n - i), f = s2.substring(n - i);
            if (isScramble(a, c) && isScramble(b, d)) {
                memory.put(key, true);
                return true;
            }
            if (isScramble(b, e) && isScramble(a, f)) {
                memory.put(key, true);
                return true;
            }
        }
        memory.put(key, false);
        return false;
    }


    public static boolean check(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        int n = s1.length();
        for (int i = 0; i < s1.length(); i++) {
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isScramble("grceat", "crgeat"));
    }
}
