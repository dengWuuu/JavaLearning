package 代码随想录.额外的题目.独一无二的出现次数;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Wu
 * @date 2022年09月23日 23:38
 */
public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        Set<Integer> ans = new HashSet<>();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if (ans.contains(integerIntegerEntry.getValue())) {
                return false;
            } else {
                ans.add(integerIntegerEntry.getValue());
            }
        }
        return true;
    }
}
