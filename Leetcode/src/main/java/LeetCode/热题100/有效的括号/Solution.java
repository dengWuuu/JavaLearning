package LeetCode.热题100.有效的括号;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Wu
 * @date 2022年08月10日 11:58
 */
public class Solution {
    Deque<Character> stack = new ArrayDeque<>();

    public boolean isValid(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.peek() != null && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }else if (c == ']') {
                if (stack.peek() != null && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }else if (c == '}') {
                if (stack.peek() != null && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
