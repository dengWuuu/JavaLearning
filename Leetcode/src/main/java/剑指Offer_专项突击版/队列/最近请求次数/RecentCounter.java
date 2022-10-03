package 剑指Offer_专项突击版.队列.最近请求次数;

import java.util.Deque;
import java.util.LinkedList;

public class RecentCounter {
    Deque<Integer> deque = new LinkedList<>();

    public RecentCounter() {

    }

    public int ping(int t) {
        deque.addLast(t);
        while (!deque.isEmpty() && t - deque.peekFirst() > 3000) {
            deque.pollFirst();
        }
        return deque.size();
    }
}