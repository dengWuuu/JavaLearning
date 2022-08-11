package LeetCode.热题100.最长公共前缀;

/**
 * @author Wu
 * @date 2022年08月09日 17:11
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 1) return strs[0];
        int length = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int sameLength = 0;
            String t1 = strs[i], t2 = strs[i + 1];
            int n1 = t1.length(), n2 = t2.length();
            int left = 0, right = 0;
            while (left < n1 && right < n2) {
                if (t1.charAt(left) == t2.charAt(right)) {
                    sameLength++;
                    left++;
                    right++;
                } else {
                    break;
                }
            }
            length = Math.max(length, sameLength);
        }
        return length == 0 ? "" : strs[0].substring(0, length);
    }
}