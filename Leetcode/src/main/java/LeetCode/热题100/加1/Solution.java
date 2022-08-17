package LeetCode.热题100.加1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年08月17日 11:04
 */
public class Solution {
    static List<Integer> ans = new LinkedList<>();

    public static int[] plusOne(int[] digits) {
        int flag = 0;
        digits[digits.length - 1] += 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += flag;
            if (digits[i] >= 10) {
                digits[i] -= 10;
                flag = 1;
            } else flag = 0;
            ans.add(0, digits[i]);
        }
        if (flag == 1) {
            ans.add(0, 1);
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9})));
    }
}