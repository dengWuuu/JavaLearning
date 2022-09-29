package 剑指offer02.middle.把字符串转换成整数;

/**
 * @author Wu
 * @date 2022年08月05日 18:39
 */
public class Solution {
    public static int strToInt(String str) {
        char[] chars = str.trim().toCharArray();
        int sign = 1, boundary = Integer.MAX_VALUE / 10;
        if (chars.length == 0) return 0;
        int i = 1;
        int ans = 0;
        if (chars[0] == '-') sign = -1;
        else if (chars[0] != '+') i = 0;
        for (int j = i; j < chars.length; j++) {
            if (chars[j] < '0' || chars[j] > '9') break;
            if (ans > boundary || ans == boundary && chars[j] > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + (chars[j] - '0');
        }
        return sign * ans;
    }
}