package LeetCode.热题100.回文数;

/**
 * @author Wu
 * @date 2022年08月08日 16:08
 */
public class Solution {
    public boolean isPalindrome(int x) {
        String s = x + "";
        int left = 0, right = s.length() - 1;
        if (s.length() % 2 != 0) return false;
        while (left <= right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public boolean other(int x) {
        int reverse = 0;

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return reverse == x || reverse / 10 == x;
    }
}
