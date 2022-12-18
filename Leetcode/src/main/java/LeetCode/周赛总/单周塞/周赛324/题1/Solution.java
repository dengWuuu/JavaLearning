package LeetCode.周赛总.单周塞.周赛324.题1;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
public class Solution {
    public int similarPairs(String[] words) {
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (judge(words[i], words[j])) ans++;
            }
        }
        return ans;
    }

    public boolean judge(String s1, String s2) {
        boolean[] l = new boolean[26];
        boolean[] r = new boolean[26];

        for (int i = 0; i < s1.length(); i++) {
            l[s1.charAt(i) - 'a'] = true;
        }
        for (int i = 0; i < s2.length(); i++) {
            r[s2.charAt(i) - 'a'] = true;
        }

        for (int i = 0; i < 26; i++) {
            if (l[i] != r[i]) return false;
        }
        return true;
    }
}