package LeetCode.热题100.最小栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * @author Wu
 * @date 2022年08月27日 19:54
 */
public class MinStack {
    Deque<Integer> stack;
    Deque<Integer> min;

    public MinStack() {
        stack = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);
        if (min.isEmpty()) min.push(val);
        else if (min.peek() >= val) {
            min.push(val);
        }
    }

    public void pop() {
        if (Objects.equals(stack.peek(), min.peek())) {
            min.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
