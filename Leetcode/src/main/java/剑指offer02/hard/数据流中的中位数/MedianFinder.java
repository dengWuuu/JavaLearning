package 剑指offer02.hard.数据流中的中位数;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Wu
 * @date 2022年07月31日 12:46
 */
class MedianFinder {
    Queue<Integer> max;
    Queue<Integer> min;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        max = new PriorityQueue<>((o1, o2) -> o2 - o1);
        min = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (max.size() == min.size()) {
            min.add(num);
            max.add(min.poll());
        } else {
            max.add(num);
            min.add(max.poll());
        }
    }

    public double findMedian() {
        return max.size() == min.size() ? (max.peek() + min.peek()) / 2.0 : max.peek();
    }
}