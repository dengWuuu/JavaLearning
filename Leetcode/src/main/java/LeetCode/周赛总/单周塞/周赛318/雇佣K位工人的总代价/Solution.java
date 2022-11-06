package LeetCode.周赛总.单周塞.周赛318.雇佣K位工人的总代价;

import java.util.*;

/**
 * @author Wu
 * @date 2022年11月06日 10:55
 */
public class Solution {
    public static long totalCost(int[] costs, int k, int candidates) {
        long cost = 0;
        PriorityQueue<Integer> l = new PriorityQueue<>();
        PriorityQueue<Integer> r = new PriorityQueue<>();
        if (candidates * 2 >= costs.length) {
            for (int j : costs) {
                l.add(j);
            }
            for (int i = 0; i < k; i++) {
                cost += l.poll();
            }
        } else {
            for (int i = 0; i < candidates; i++) {
                l.add(costs[i]);
            }
            for (int i = costs.length - 1; i >= costs.length - candidates; i--) {
                r.add(costs[i]);
            }
            int idxL = 0;
            int idxR = 0;
            for (int i = 0; i < k; i++) {
                int left = l.isEmpty() ? Integer.MAX_VALUE : l.peek();
                int right = r.isEmpty() ? Integer.MAX_VALUE : r.peek();
                if (left <= right) {
                    cost += left;
                    l.poll();
                    idxL++;
                    if (l.size() + idxL < costs.length - candidates - idxR) l.add(costs[l.size() + idxL]);
                } else {
                    cost += right;
                    r.poll();
                    idxR++;
                    if (costs.length - candidates - idxR > l.size() + idxL - 1)
                        r.add(costs[costs.length - candidates - idxR]);
                }
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        System.out.println(totalCost(new int[]{100, 48, 6, 73, 4}, 3, 2));
    }
}