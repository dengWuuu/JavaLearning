package 代码随想录.贪心.单调递增的数字;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年09月17日 9:51
 */
public class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] number = String.valueOf(n).toCharArray();
        int idx = number.length;
        for (int i = number.length - 1; i > 0; i--) {
            if (number[i - 1] > number[i]) {
                number[i - 1]--;
                idx = i;
            }
        }
        for (int i = idx; i < number.length; i++) {
            number[i] = '9';
        }
        return Integer.parseInt(String.valueOf(number));
    }
}
