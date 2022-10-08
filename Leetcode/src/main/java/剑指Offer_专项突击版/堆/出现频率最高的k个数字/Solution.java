package 剑指Offer_专项突击版.堆.出现频率最高的k个数字;

import java.util.*;

/**
 * @author Wu
 * @date 2022年10月07日 22:57
 */
public class Solution {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        PriorityQueue<int[]> ans = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (ans.size() < k) {
                ans.add(new int[]{entry.getKey(), entry.getValue()});
            } else {
                int count = entry.getValue();
                if (count > ans.peek()[1]) {
                    ans.poll();
                    ans.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = ans.poll()[0];
        }
        return ret;
    }
}
