package LeetCode.周赛总.单周塞.周赛313.对字母串可执行的最大删除数;

import java.util.*;

/**
 * @author Wu
 * @date 2022年10月02日 11:01
 */
public class Solution {
    Map<String, Integer> visitedMap = new HashMap<>();
    int max = 0;

    public int deleteString(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        if (set.size() == 1) {
            return s.length();
        }
        dfs(s, 0);
        return max;
    }

    private void dfs(String s, int cnt) {
        max = Math.max(max, cnt);
        if (s.isEmpty()) {
            return;
        }
        if (visitedMap.containsKey(s) && visitedMap.get(s) >= cnt) {
            return;
        } else {
            visitedMap.put(s, cnt);
        }
        // 尝试找前缀并递归
        for (int i = 1; i <= s.length() / 2; i++) {
            String prefix = s.substring(0, i);
            if (s.substring(i).startsWith(prefix)) {
                dfs(s.substring(i), cnt + 1);
            }
        }
        // 删除全部
        dfs("", cnt + 1);
    }
}
