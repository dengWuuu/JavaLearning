package LeetCode.热题100.简化路径;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Wu
 * @date 2022年08月17日 12:05
 */
public class Solution {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        //初始化栈
        for (String s : split) {
            if ("..".equals(s)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (s.length() > 0 && !s.equals(".")) {
                stack.add(s);
            }
        }

        if (stack.isEmpty()) sb.append("/");
        else {
            while (!stack.isEmpty()){
                sb.append('/').append(stack.poll());
            }
        }

        return sb.toString();
    }
}
