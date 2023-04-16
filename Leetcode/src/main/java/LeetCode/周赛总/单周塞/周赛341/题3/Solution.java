package LeetCode.周赛总.单周塞.周赛341.题3;

import java.util.Arrays;

class Solution {
    public int addMinimum(String word) {
        int cnt = 0;
        int i = 0, j = 1;
        int[] c = new int[3];
        c[word.charAt(0) - 'a']++;
        while (j < word.length()) {
            if (word.charAt(j) - word.charAt(j - 1) >= 1) {
                c[word.charAt(j) - 'a']++;
                j++;
            } else {
                cnt += 3 - c[0] - c[1] - c[2];
                c = new int[3];
                i = j;
                c[word.charAt(i) - 'a']++;
                j = i + 1;
            }
        }
        cnt += 3 - c[0] - c[1] - c[2];
        return cnt;
    }
}