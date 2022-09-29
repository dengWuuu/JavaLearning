package 剑指offer02.middle.队列的最大值;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Wu
 * @date 2022年08月05日 11:20
 */
public class MaxQueue {
    Deque<Integer> deque;
    Deque<Integer> max;

    public MaxQueue() {
        deque = new ArrayDeque<>();
        max = new ArrayDeque<>();
    }

    public int max_value() {
        return deque.isEmpty() ? -1 : max.peekFirst();
    }

    public void push_back(int value) {
        deque.addLast(value);
        while (!max.isEmpty() && max.peekLast() < value) {
            max.removeLast();
        }
        max.addLast(value);
    }

    public int pop_front() {
        if (deque.isEmpty()) return -1;
        else {
            if (deque.peekFirst().equals(max.peekFirst())) {
                max.pop();
            }
            return deque.pop();
        }
    }
}