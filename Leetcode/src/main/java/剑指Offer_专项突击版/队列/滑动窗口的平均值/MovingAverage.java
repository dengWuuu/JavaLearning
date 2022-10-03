package 剑指Offer_专项突击版.队列.滑动窗口的平均值;

import java.util.Deque;
import java.util.LinkedList;

public class MovingAverage {
    Deque<Double> deque = new LinkedList<>();
    int size;
    int capacity;
    Double totalSum;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        this.capacity = size;
        totalSum = 0.0;
    }

    public double next(int val) {
        if (size < capacity) {
            deque.addLast((double) val);
            totalSum += val;
            size++;
        } else {
            Double integer = deque.pollFirst();
            totalSum -= integer;
            totalSum += val;
            deque.addLast((double) val);
        }
        return totalSum / size / 1.0;
    }
}