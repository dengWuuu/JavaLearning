package 腾讯题库.POW;

public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        double ans = 1;
        boolean flag = n < 0;
        long num = n;
        if (flag) num = -num;
        while (num >= 1) {
            if (num % 2 != 0) {
                ans *= x;
            }
            x *= x;
            num /= 2;
        }
        return flag ? 1 / ans : ans;
    }
}