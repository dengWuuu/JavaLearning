package LeetCode.热题100.外观数列;

/**
 * @author Wu
 * @date 2022年08月13日 12:27
 */
public class Solution {
    public static String countAndSay(int n) {
        if (n == 1) return "1";
        StringBuilder sb = new StringBuilder();
        String s = countAndSay(n - 1);
        if (s.length() == 1) return "1" + s;
        int left = 0, right = 0;
        while (left < s.length() && right < s.length()) {
            while (right < s.length() && s.charAt(left) == s.charAt(right)) {
                right++;
            }
            sb.append(right - left).append(s.charAt(left));
            left = right;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}
