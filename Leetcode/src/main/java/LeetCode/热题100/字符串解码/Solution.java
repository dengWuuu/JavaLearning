package LeetCode.热题100.字符串解码;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wu
 * @date 2022年08月31日 18:23
 */
public class Solution {
    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        Deque<String> stack = new LinkedList<>();
        Deque<Integer> numStack = new LinkedList<>();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                stack.add(ans.toString());
                numStack.add(num);
                ans = new StringBuilder();
                num = 0;
            } else if (s.charAt(i) == ']') {
                StringBuilder mutiStr = new StringBuilder();
                Integer integer = numStack.pollLast();
                for (int j = 0; j < integer; j++) {
                    mutiStr.append(ans);
                }
                ans = new StringBuilder(stack.pollLast() + mutiStr);
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = num * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
            } else ans.append(s.charAt(i));
        }

        return ans.toString();
    }
}
