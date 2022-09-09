package 代码随想录.栈与队列.删除字符串中的所有相邻重复项;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wu
 * @date 2022年09月08日 21:56
 */
public class Solution {
    Deque<Character> stack = new LinkedList<>();

    public String removeDuplicates(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty()) {
                if (stack.peekLast() == s.charAt(i)) {
                    stack.pollLast();
                } else {
                    stack.add(s.charAt(i));
                }
            } else stack.add(s.charAt(i));
        }
        StringBuilder ans = new StringBuilder();
        for (Character character : stack) {
            ans.append(character);
        }
        return ans.toString();
    }
}
