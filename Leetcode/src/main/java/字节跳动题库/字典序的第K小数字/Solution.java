package 字节跳动题库.字典序的第K小数字;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static int findKthNumber(int n, int k) {
        int ans = 1;
        while (k > 1) {
            int cnt = getCnt(ans, n);
            if (cnt < k) {
                k -= cnt;
                ans++;
            } else {
                k--;
                ans *= 10;
            }
        }
        return ans;
    }

    public static int getCnt(int x, int limit) {
        String a = String.valueOf(x), b = String.valueOf(limit);
        int m = a.length(), n = b.length(), dis = n - m;
        int ans = 0;
        int prefix = Integer.parseInt(b.substring(0, m));
        for (int i = 0; i < dis; i++) {
            ans += Math.pow(10, i);
        }

        if (prefix > x) ans += Math.pow(10, dis);
        else if (prefix == x) ans += limit - x * Math.pow(10, dis) + 1;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getCnt(124, 12456));
//        System.out.println(getCnt(123, 12456));
    }
}