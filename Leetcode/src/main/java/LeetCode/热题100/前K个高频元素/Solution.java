package LeetCode.热题100.前K个高频元素;

import java.util.*;

/**
 * @author Wu
 * @date 2022年08月31日 12:32
 */
public class Solution {
    public static int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        Map<Integer, Integer> hash = new HashMap<>();
        for (int num : nums) {
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }

        Set<Map.Entry<Integer, Integer>> entries = hash.entrySet();
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry : entries) {
            heap.offer(entry);
            if (heap.size() > k) heap.poll();
        }

        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll().getKey();
        }
        return ans;
    }

}
