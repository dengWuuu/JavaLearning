package LeetCode.热题100.最后一个单词的长度;

/**
 * https://leetcode.cn/problems/length-of-last-word/
 *
 * @author Wu
 * @date 2022年08月16日 11:37
 */
public class Solution {
    public static int lengthOfLastWord(String s) {
        int n = s.length();
        int ans = 0;
        int index = s.length() - 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') index--;
            else break;
        }
        for (int i = index; i >= 0; i--) {
            if (s.charAt(i) == ' ') break;
            else {
                ans++;
            }

        }
        return ans;
    }
}