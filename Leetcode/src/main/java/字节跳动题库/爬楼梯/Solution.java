package 字节跳动题库.爬楼梯;

public class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int p = 1, q = 2, r = 0;
        for (int i = 2; i <= n; i++) {
            r = p + q;
            p = q;
            q = r;
        }
        return r;
    }
}
