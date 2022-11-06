package LeetCode.周赛总.单周塞.周赛317.最流行的视频创作者;

import java.util.*;

/**
 * @author Wu
 * @date 2022年10月30日 10:32
 */
public class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        List<List<String>> ans = new LinkedList<>();
        int n = creators.length;
        for (int i = 0; i < n; i++) {
            map1.put(creators[i], map1.getOrDefault(creators[i], 0) + views[i]);
            int id = map2.getOrDefault(creators[i], -1);
            if (id == -1) {
                map2.put(creators[i], i);
            } else {
                if (views[id] < views[i]) {
                    map2.put(creators[i], i);
                    continue;
                }
                if (ids[id].compareTo(ids[i]) > 0 && views[id] == views[i]) {
                    map2.put(creators[i], i);
                }
            }
        }

        int max = 0;
        for (Map.Entry<String, Integer> stringIntegerEntry : map1.entrySet()) {
            max = Math.max(stringIntegerEntry.getValue(), max);
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : map1.entrySet()) {
            if (stringIntegerEntry.getValue() == max) {
                List<String> tmp = new ArrayList<>();
                tmp.add(stringIntegerEntry.getKey());
                tmp.add(ids[map2.get(stringIntegerEntry.getKey())]);
                ans.add(tmp);
            }
        }
        return ans;
    }
}
