package LeetCode.热题100.字符串转换整数;

/**
 * @author Wu
 * @date 2022年08月08日 15:20
 */
public class Solution {
    static int max = Integer.MAX_VALUE / 10;
    static int flag = 1;

    public static int myAtoi(String s) {
        String trim = s.trim();
        int length = trim.length();
        int i = 0;
        int ans = 0;

        if (length == 0) return 0;

        if (trim.charAt(i) == '-') {
            flag = -1;
            i++;
        } else if (trim.charAt(i) == '+') i++;

        while (i < length) {
            if (trim.charAt(i) >= '0' && trim.charAt(i) <= '9') {
                ans = ans * 10 + trim.charAt(i) - '0';
            } else {
                break;
            }
            if (ans > max && i + 1 < length && trim.charAt(i + 1) >= '0'
                    && trim.charAt(i + 1) <= '9'
                    || (ans == max && trim.charAt(i + 1) > '7')) {
                return flag == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            i++;
        }
        return flag == -1 ? ans * -1 : ans;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("-2147483646"));
        System.out.println(max);
    }
}