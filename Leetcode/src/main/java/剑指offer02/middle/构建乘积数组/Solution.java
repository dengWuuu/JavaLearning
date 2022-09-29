package 剑指offer02.middle.构建乘积数组;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年08月05日 16:58
 */
public class Solution {
    public int[] constructArr(int[] a) {
        int n = a.length;
        if (n == 0) return new int[0];
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = a[i - 1] * ans[i - 1];
        }

        int R = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * R;
            R *= a[i];
        }
        return ans;
    }
}