package LeetCode.二零二三年每日一题.餐盘栈;

import java.util.*;

/**
 * @author Wu
 * @date 2023年04月28日 23:15
 */
public class DinnerPlates {
    int capacity;
    List<Deque<Integer>> stacks = new ArrayList<>();
    PriorityQueue<Integer> idx = new PriorityQueue<>();

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
    }

    public void push(int val) {
        if (!idx.isEmpty() && idx.peek() >= stacks.size()) {
            idx.clear();
        }
        if (idx.isEmpty()) {
            stacks.add(new ArrayDeque<>());
            stacks.get(stacks.size() - 1).add(val);
            if (capacity > 1) idx.add(stacks.size() - 1);
        } else {
            Deque<Integer> deque = stacks.get(idx.peek());
            deque.push(val);
            if (deque.size() >= capacity) idx.poll();
        }
    }

    public int pop() {
        return popAtStack(stacks.size() - 1);
    }

    public int popAtStack(int index) {
        if (index < 0 || index >= stacks.size() || stacks.get(index).isEmpty()) return -1;
        Deque<Integer> deque = stacks.get(index);
        if (deque.size() == capacity) {
            idx.add(index);
        }
        int val = deque.pop();
        while (!stacks.isEmpty()) {
            if (stacks.get(stacks.size() - 1).isEmpty()) stacks.remove(stacks.size() - 1);
            else break;
        }
        return val;
    }
}