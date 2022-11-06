package LeetCode.周赛总.单周塞.米哈游单周赛.检查相同字母间的距离;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年09月04日 10:30
 */
public class Solution {
    Map<String, Integer> map = new HashMap<>();

    public boolean checkDistances(String s, int[] distance) {
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i) + "1")) {
                map.put(s.charAt(i) + "2", i);
            } else {
                map.put(s.charAt(i) + "1", i);
            }
        }

        for (int i = 0; i < distance.length; i++) {
            char letter = (char) ('a' + i);
            int num = distance[i];
            int idx1 = map.getOrDefault(letter + "1", 0);
            int idx2 = map.getOrDefault(letter + "2", 0);
            if (idx1 == 0 && idx2 == 0) continue;
            if (num != idx2 - idx1 - 1) return false;
        }
        return true;
    }
}