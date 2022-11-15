package LeetCode.周赛总.单周塞.周赛319.题4;

import java.util.Arrays;

class Solution {
    public static int maxPalindromes(String s, int k) {
        int length = s.length();
        boolean[][] flag = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            flag[i][i] = true;
        }

        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i + 1 >= j - 1) {
                        flag[i][j] = true;
                        continue;
                    }
                    flag[i][j] = flag[i + 1][j - 1];
                }
            }
        }

        int[] f = new int[length + 1];

        for (int i = 1; i <= length; i++) {
            f[i] = f[i - 1];
            for (int j = i - k; j >= 0; j--) {
                if (flag[j][i - 1]) f[i] = Math.max(f[i], f[j] + 1);
            }
        }
        return f[length];
    }
}