package 剑指Offer_专项突击版.数组.二进制加法;

/**
 * @author Wu
 * @date 2022年09月26日 18:18
 */
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int left = a.length() - 1, right = b.length() - 1, count = 0;
        while (left >= 0 && right >= 0) {
            int aBit = a.charAt(left) - '0';
            int bBit = b.charAt(right) - '0';
            int sum = aBit + bBit + count;
            if (sum >= 2) {
                count = 1;
                sum -= 2;
            } else {
                count = 0;
            }
            sb.insert(0, sum);
            left--;
            right--;
        }

        while (left >= 0) {
            int sum = a.charAt(left--) - '0' + count;
            if (sum >= 2) {
                sum -= 2;
                count = 1;
            } else count = 0;
            sb.insert(0, sum);
        }

        while (right >= 0) {
            int sum = b.charAt(right--) - '0' + count;
            if (sum >= 2) {
                sum -= 2;
                count = 1;
            } else count = 0;
            sb.insert(0, sum);
        }

        if (count > 0) sb.insert(0, 1);
        return sb.toString();
    }
}
