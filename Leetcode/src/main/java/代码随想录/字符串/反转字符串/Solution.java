package 代码随想录.字符串.反转字符串;

/**
 * @author Wu
 * @date 2022年09月06日 20:10
 */
public class Solution {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < s.length && right >= 0 && left <= right) {
            swap(s, left, right);
            left++;
            right--;
        }
    }

    public void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
