package LeetCode.二零二二年每日一题.十一月.第N个神奇数字;

/**
 * @author Wu
 * @date 2022年11月22日 16:11
 */
public class Solution {
    int mod = (int) (1e9 + 7);

    public int nthMagicalNumber(int n, int a, int b) {
        long l = Math.min(a, b), r = (long) n * Math.min(a, b);
        int c = lcm(a, b);
        while (l <= r) {
            long mid = (r - l) / 2 + l;
            System.out.println("l:" + l + "  r:" + r + "  mid:" + mid);
            long cnt = mid / a + mid / b - mid / c;
            if (cnt >= n) {
                r = mid - 1;
            } else l = mid + 1;
        }
        return (int) (l%mod);
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }


    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}