package 剑指Offer_专项突击版.字符串.有效的回文;

/**
 * @author Wu
 * @date 2022年09月29日 9:01
 */
public class Solution {
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !(Character.isLetterOrDigit(s.charAt(left)))) left++;
            while (left < right && !(Character.isLetterOrDigit(s.charAt(right)))) right--;
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
                left++;
                right--;
            }
        }
        return true;
    }
}
