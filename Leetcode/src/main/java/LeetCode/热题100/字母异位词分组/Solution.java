package LeetCode.热题100.字母异位词分组;

import java.util.*;

/**
 * @author Wu
 * @date 2022年08月15日 12:06
 */
public class Solution {
    Map<String, List<String>> map = new HashMap<>();

    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        for (String str : strs) {
            int[] count = new int[26];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    sb.append((char) i + 'a');
                    sb.append(count[i]);
                }
            }
            String key = sb.toString();
            List<String> orDefault = map.getOrDefault(key, new ArrayList<>());
            orDefault.add(str);
            map.put(sb.toString(), orDefault);
        }
        return new ArrayList<>(map.values());
    }
}
