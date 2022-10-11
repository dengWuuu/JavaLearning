package 剑指Offer_专项突击版.排序.数组相对排序;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Wu
 * @date 2022年10月11日 18:53
 */
public class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        Comparator<Integer> c = new Comparator<>() {
            @Override
            public int compare(Integer x, Integer y) {
                if (map.containsKey(x) && map.containsKey(y)) {
                    return map.get(x) - map.get(y);
                } else if (map.containsKey(x)) {
                    return -1;
                } else if (map.containsKey(y)) return 1;
                else {
                    return x - y;
                }
            }
            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };
        List<Integer> list = Arrays.stream(arr1).boxed().sorted(c).collect(Collectors.toList());
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}