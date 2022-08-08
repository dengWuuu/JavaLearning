package LeetCode.热题100.整数反转;

/**
 * @author Wu
 * @date 2022年08月08日 12:49
 */
public class Solution {
    static int maxValue = Integer.MAX_VALUE / 10;
    static int flag = 1;

    public static int reverse(int x) {
        if (x == Integer.MAX_VALUE || x == Integer.MIN_VALUE) return 0;
        if (x <= 0) {
            flag = -1;
            x = -x;
        }
        int ans = 0;
        while (x != 0) {
            int b = x % 10;
            ans = ans * 10 + b;
            if (ans > maxValue && (x /= 10) != 0) {
                return 0;
            }
            x /= 10;
        }
        return ans * flag;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-23));
    }
}
