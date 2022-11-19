package 腾讯题库.快速除法;

class Solution {
    public static int divide(int a, int b) {
        long x = a, y = b;
        boolean isNeg = (x > 0 && y < 0) || (x < 0 && y > 0);
        if (x < 0) x = -x;
        if (y < 0) y = -y;
        long l = 0, r = x;
        while (l <= r) {
            long mid = (l + r) >> 1;
            if (mul(mid, y) <= x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        long ans = isNeg ? -r : r;
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return (int) ans;
    }

    static long mul(long a, long k) {
        long ans = 0;
        while (k > 0) {
            if ((k & 1) == 1) ans += a;
            k >>= 1;
            a += a;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(mul(4, 5));
    }
}