package 剑指Offer_专项突击版.字符串.最多删除一个字符得到回文;

/**
 * @author Wu
 * @date 2022年09月29日 9:20
 */
public class Solution {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        boolean flag = false;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                if (right == left + 1) return true;
                if (!flag) {
                    return check(s, left + 1, right) || check(s, left, right - 1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean check(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
