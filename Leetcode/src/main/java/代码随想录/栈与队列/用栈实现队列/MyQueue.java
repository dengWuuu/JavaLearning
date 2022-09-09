package 代码随想录.栈与队列.用栈实现队列;

import java.util.*;

/**
 * @author Wu
 * @date 2022年09月08日 9:45
 */
class MyStack {
    // Deque 接口继承了 Queue 接口
    // 所以 Queue 中的 add、poll、peek等效于 Deque 中的 addLast、pollFirst、peekFirst
    Deque<Integer> que1;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        que1 = new ArrayDeque<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        que1.addLast(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int size = que1.size();
        size--;
        // 将 que1 导入 que2 ，但留下最后一个值
        while (size-- > 0) {
            que1.addLast(que1.peekFirst());
            que1.pollFirst();
        }
        return que1.pollFirst();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return que1.peekLast();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return que1.isEmpty();
    }
}