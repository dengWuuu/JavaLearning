package 剑指Offer_专项突击版.数组.排序数组中两个数字之和;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年09月26日 19:34
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{i, map.get(target - numbers[i])};
            }
        }
        return new int[]{};
    }

}
