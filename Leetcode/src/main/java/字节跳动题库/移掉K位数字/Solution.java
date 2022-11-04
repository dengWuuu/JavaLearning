package 字节跳动题库.移掉K位数字;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Wu
 * @date 2022年11月04日 19:09
 */
public class Solution {
    public static String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i < num.length(); i++) {
            while (!stack.isEmpty() && k > 0 && num.charAt(stack.peek()) > num.charAt(i)) {
                k--;
                stack.pop();
            }
            stack.push(i);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        while (!stack.isEmpty()) {
            sb.append(num.charAt(stack.pollLast()));
        }
        return zeroCheck(sb);
    }

    public static String zeroCheck(StringBuilder sb) {
        int n = sb.length();
        for (int i = 0; i < n; i++) {
            if (sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            } else break;
        }
        return sb.toString().equals("") ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("10001", 1));
    }
}