package 剑指Offer_专项突击版.图.开密码锁;

import java.util.*;

/**
 * @author Wu
 * @date 2022年10月19日 19:30
 */
public class Solution {
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) return 0;
        Set<String> dead = new HashSet<>(List.of(deadends));
        Deque<char[]> deque = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int step = 0;
        char[] base = {'0', '0', '0', '0'};
        if (dead.contains(String.valueOf(base))) return -1;
        deque.add(base);
        visited.add(String.valueOf(base));
        while (!deque.isEmpty()) {
            ++step;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                char[] poll = deque.poll();
                List<String> strings = get(poll);
                for (String next : strings) {
                    if (dead.contains(next) || !visited.contains(next)) continue;
                    if (next.equals(target)) {
                        return step;
                    }
                    deque.add(next.toCharArray());
                    visited.add(next);
                }
            }
        }
        return -1;
    }

    public char numPrev(char x) {
        return x == '0' ? '9' : (char) (x - 1);
    }

    public char numSucc(char x) {
        return x == '9' ? '0' : (char) (x + 1);
    }

    /**
     * 枚举一次旋转能出来的字符串
     */
    public List<String> get(char[] str) {
        List<String> ans = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            char num = str[i];
            str[i] = numPrev(num);
            ans.add(String.valueOf(str));
            str[i] = numSucc(num);
            ans.add(String.valueOf(str));
            str[i] = num;
        }
        return ans;
    }
}