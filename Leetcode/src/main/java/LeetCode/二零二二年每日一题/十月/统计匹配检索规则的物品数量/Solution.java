package LeetCode.二零二二年每日一题.十月.统计匹配检索规则的物品数量;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年10月29日 15:25
 */
public class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        Map<String, Integer> map = new HashMap<>();
        map.put("type", 0);
        map.put("color", 1);
        map.put("name", 2);

        int idx = map.get(ruleKey);

        int ans = 0;
        for (int i = 0; i < items.size(); i++) {
            List<String> strings = items.get(i);
            if (ruleValue.equals(strings.get(idx))) ans++;
        }
        return ans;
    }
}