package 腾讯题库.有效的括号字符串;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Wu
 * @date 2022年11月17日 10:26
 */
public class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> stackL = new ArrayDeque<>();
        Deque<Integer> stackM = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stackL.push(i);
            } else if (s.charAt(i) == '*') {
                stackM.push(i);
            } else {
                if (!stackL.isEmpty()) {
                    stackL.pop();
                } else if (!stackM.isEmpty()) {
                    stackM.pop();
                } else return false;
            }
        }

        while (!stackL.isEmpty() && !stackM.isEmpty()) {
            int idx1 = stackL.pop();
            int idx2 = stackM.pop();
            if (idx1 > idx2) return false;
        }
        return stackL.isEmpty();
    }
}