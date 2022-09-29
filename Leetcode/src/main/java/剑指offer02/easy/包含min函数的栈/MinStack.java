package 剑指offer02.easy.包含min函数的栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author Wu
 * @date 2022年07月29日 11:23
 */
class MinStack {
    Deque<Integer> deque;
    Deque<Integer> min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        deque = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }

    public void push(int x) {
        deque.push(x);
        if (min.isEmpty() || min.peek() > x) {
            min.push(x);
        }

    }

    public void pop() {
        if (deque.pop().equals(min.peek())) {
            min.pop();
        }
    }

    public int top() {
        return deque.peek();
    }

    public int min() {
        return min.peek();
    }
}