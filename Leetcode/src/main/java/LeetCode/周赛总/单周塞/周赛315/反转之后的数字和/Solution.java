package LeetCode.周赛总.单周塞.周赛315.反转之后的数字和;

/**
 * @author Wu
 * @date 2022年10月16日 10:43
 */
public class Solution {
    public static boolean sumOfNumberAndReverse(int num) {
        if (num ==0) return true;
        int count = (num + "").length();
        for (int i = 0; i < num; i++) {
            int reverse = reverse(i + "");
            if (reverse + i == num) return true;
        }
        return false;
    }

    public static int reverse(String str) {
        StringBuilder s = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            s.append(str.charAt(i));
        }
        return Integer.parseInt(s.toString());
    }
}
