package LeetCode.周赛总.单周塞.周赛310.出现最频繁的偶数元素;

import java.util.*;

/**
 * @author Wu
 * @date 2022年09月11日 10:31
 */
public class Solution {
     Map<Integer, Integer> map = new HashMap<>();

    public  int mostFrequentEven(int[] nums) {
        int max = Integer.MIN_VALUE, ans = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num % 2 == 0) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        Set<Integer> integers = map.keySet();
        for (Integer integer : integers) {
            Integer times = map.get(integer);
            if (times > max) {
                max = times;
                ans = integer;
            } else if (times == max && integer < ans) {
                ans = integer;
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}
