package 剑指Offer_专项突击版.字符串.含有所有字符的最短字符串;

/**
 * @author Wu
 * @date 2022年09月28日 19:19
 */
public class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        int[] arr = new int[58];
        for (int i = 0; i < t.length(); i++) {
            arr[s.charAt(i) - 'A']++;
            arr[t.charAt(i) - 'A']--;
        }
        int diff = 0;
        for (int j : arr) {
            if (j < 0) diff++;
        }
        if (diff == 0) return s.substring(0, t.length());
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1, left = 0;
        for (int right = t.length(); right < s.length(); right++) {
            int next = s.charAt(right) - 'A';
            arr[next]++;
            if (arr[next] == 0) diff--;
            if (diff != 0) continue;

            while (diff == 0) {
                int idx = s.charAt(left) - 'A';
                arr[idx]--;
                if (arr[idx] == -1) diff++;
                left++;
            }
            if (right - left + 2 < len) {
                len = right - left + 2;
                ansL = left - 1;
                ansR = right;
            }

        }
        return ansL == -1 ? "" : s.substring(ansL, ansR + 1);
    }
}
