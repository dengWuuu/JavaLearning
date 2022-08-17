package LeetCode.热题100.二进制求和;

/**
 * @author Wu
 * @date 2022年08月17日 11:21
 */
public class Solution {
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int m = a.length(), n = b.length();
        int left = m - 1, right = n - 1;
        int flag = 0;
        while (left >= 0 && right >= 0) {
            int i = Integer.parseInt(String.valueOf(a.charAt(left)));
            int j = Integer.parseInt(String.valueOf(b.charAt(right)));
            int sum = i + j + flag;
            if (sum >= 2) {
                sum -= 2;
                flag = 1;
            } else flag = 0;
            sb.insert(0, sum);
            left--;
            right--;
        }
        while (left >= 0) {
            int i = Integer.parseInt(String.valueOf(a.charAt(left)));
            int sum = i + flag;
            if (sum >= 2) {
                sum -= 2;
                flag = 1;
            } else flag = 0;
            sb.insert(0, sum);
            left--;
        }
        while (right >= 0) {
            int i = Integer.parseInt(String.valueOf(b.charAt(right)));
            int sum = i + flag;
            if (sum >= 2) {
                sum -= 2;
                flag = 1;
            } else flag = 0;
            sb.insert(0, sum);
            right--;
        }
        if (flag == 1) sb.insert(0, "1");
        return sb.toString();
    }
}
