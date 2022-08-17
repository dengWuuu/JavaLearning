package LeetCode.热题100.hard.有效数字;

/**
 * @author Wu
 * @date 2022年08月16日 20:46
 */
public class Solution {
    public static boolean isNumber(String s) {
        boolean flag = false, firstDot = false;
        String trim = s.trim();
        int length = trim.length();
        for (int i = 0; i < length; i++) {
            if (trim.charAt(i) == '+' || trim.charAt(i) == '-') {
                if (flag) return false;
                if (i == 0 && trim.length() > 1) {
                    flag = true;
                } else return false;
            } else if (trim.charAt(i) == 'e' || trim.charAt(i) == 'E') {
                if (i > 0 && ((trim.charAt(i - 1) >= '0' && trim.charAt(i - 1) <= '9') || trim.charAt(i - 1) == '.')) {
                    return isInteger(trim.substring(i + 1));
                }
                return false;
            } else if (trim.charAt(i) == '.') {
                if (!firstDot && ((i > 0 && trim.charAt(i - 1) <= '9' && trim.charAt(i - 1) >= '0')
                        || (i + 1 < length && trim.charAt(i + 1) <= '9' && trim.charAt(i + 1) >= '0'))) {
                    firstDot = true;
                    continue;
                }
                return false;
            } else if (!(trim.charAt(i) >= '0' && trim.charAt(i) <= '9')) return false;
        }
        return true;
    }

    public static boolean isInteger(String subString) {
        if (subString.isBlank()) return false;
        boolean firstFlag = false;
        for (int i = 0; i < subString.length(); i++) {
            if (subString.charAt(i) == '+' || subString.charAt(i) == '-') {
                if (!firstFlag && i == 0 && subString.length() > 1) firstFlag = true;
                else return false;
                continue;
            }
            if (i == 0 && subString.charAt(0) == '0' && subString.length() == 1) return false;
            if (!(subString.charAt(i) >= '0' && subString.charAt(i) <= '9')) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isNumber("+3.e04116"));
    }
}
