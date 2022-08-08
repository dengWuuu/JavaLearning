package LeetCode.热题100.Z字形变换;

/**
 * @author Wu
 * @date 2022年08月08日 11:34
 */
public class Solution {
    public static String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        if (n <= 1) return s;
        int t = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            int j = i;
            int o = 0;
            while (j < n) {
                sb.append(s.charAt(j));
                if (i > 0 && i < numRows - 1 && o + t - i < n) {
                    sb.append(s.charAt(o + t - i));
                }
                j += t;
                o += t;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}