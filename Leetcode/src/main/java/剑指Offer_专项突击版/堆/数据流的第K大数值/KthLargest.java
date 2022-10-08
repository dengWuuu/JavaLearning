package 剑指Offer_专项突击版.堆.数据流的第K大数值;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Wu
 * @date 2022年10月07日 15:22
 */
public class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<Integer>();
        for (int x : nums) {
            add(x);
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}