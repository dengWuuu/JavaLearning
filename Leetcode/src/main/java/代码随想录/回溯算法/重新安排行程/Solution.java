package 代码随想录.回溯算法.重新安排行程;

import java.util.*;

/**
 * @author Wu
 * @date 2022年09月14日 19:39
 */
public class Solution {
    List<String> ans = new ArrayList<>() {{
        add("JFK");
    }};
    Map<String, Map<String, Integer>> map = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> t : tickets) {
            Map<String, Integer> times = map.getOrDefault(t.get(0), new TreeMap<>());
            times.put(t.get(1), times.getOrDefault(t.get(1), 0) + 1);
            map.put(t.get(0), times);
        }
        backTrack(tickets);
        return ans;
    }

    public boolean backTrack(List<List<String>> tickets) {
        if (ans.size() == tickets.size() + 1) return true;
        String last = ans.get(ans.size() - 1);
        if (map.containsKey(last)) {
            for (Map.Entry<String, Integer> entry : map.get(last).entrySet()) {
                int count = entry.getValue();
                if (count > 0) {
                    ans.add(entry.getKey());
                    entry.setValue(count - 1);
                    if (backTrack(tickets)) return true;
                    ans.remove(ans.size() - 1);
                    entry.setValue(count);
                }
            }
        }
        return false;
    }
}
