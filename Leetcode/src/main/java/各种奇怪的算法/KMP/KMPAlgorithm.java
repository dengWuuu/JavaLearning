package 各种奇怪的算法.KMP;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年09月07日 12:19
 */
public class KMPAlgorithm {
    int[] next;

    public boolean repeatedSubstringPattern(String s) {
        if (s.length() <= 1) return true;
        return KMP(s.substring(1) + s.substring(0, s.length() - 1), s);
    }

    public boolean KMP(String s, String pattern) {
        next = new int[s.length()];
        getNext(pattern);
        int j = -1;
        for (int i = 0; i < s.length(); i++) {
            while (j >= 0 && s.charAt(i) != pattern.charAt(j + 1)) {
                j = next[j];
            }
            if (s.charAt(i) == pattern.charAt(j + 1)) {
                j++;
            }
            if (j == pattern.length() - 1) return true;
        }
        return false;
    }

    public void getNext(String pattern) {
        int j = -1;
        next[0] = j;
        for (int i = 1; i < pattern.length(); i++) {
            while (j >= 0 && pattern.charAt(i) != pattern.charAt(j + 1)) j = next[j];
            if (pattern.charAt(i) == pattern.charAt(j + 1)) j++;
            next[i] = j;
        }
    }
}
