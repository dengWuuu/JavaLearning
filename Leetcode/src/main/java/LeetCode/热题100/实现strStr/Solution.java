package LeetCode.热题100.实现strStr;

import java.util.Locale;

/**
 * @author Wu
 * @date 2022年08月11日 16:28
 */
public class Solution {
    static int[] next;

    public static int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        next = new int[n + 1];
        getNext(needle.toCharArray(), n);
        return KMP(haystack.toCharArray(), needle.toCharArray());
    }

    static int KMP(char[] haystack, char[] needle) {
        int i = 0, j = 0;
        while (i < haystack.length && j < needle.length) {
            if (j == -1 || haystack[i] == needle[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == needle.length) return i - j;
        else return -1;
    }


    static void getNext(char[] chars, int length) {
        next[0] = -1;
        int i = 0, j = -1;
        while (i < length - 1) {
            if (j == -1 || chars[i] == chars[j]) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
    }
}