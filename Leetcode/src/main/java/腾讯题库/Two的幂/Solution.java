package 腾讯题库.Two的幂;

/**
 * @author Wu
 * @date 2022年11月19日 20:47
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        int n = 16;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(-n));
        System.out.println(n & (-n));
    }

}