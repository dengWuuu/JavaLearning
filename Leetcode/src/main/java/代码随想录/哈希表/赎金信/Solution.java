package 代码随想录.哈希表.赎金信;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年09月06日 19:13
 */
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int n = ransomNote.length(), m = magazine.length();
        if (n > m) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            char c = ransomNote.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) > 0) {
                    map.put(c, map.get(c) - 1);
                } else return false;
            } else return false;
        }
        return true;
    }
}
