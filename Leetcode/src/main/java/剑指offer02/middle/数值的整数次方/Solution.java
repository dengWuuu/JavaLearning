package 剑指offer02.middle.数值的整数次方;

/**
 * @author Wu
 * @date 2022年07月25日 15:10
 */
public class Solution {
    public double myPow(double x, int n) {
        return n >= 0 ? powHelper(x, n) : 1.0 / powHelper(x, -n);
    }

    public double powHelper(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double y = powHelper(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
}