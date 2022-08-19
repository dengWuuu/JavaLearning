package LeetCode.热题100.hard.最小覆盖子串;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * https://leetcode.cn/problems/minimum-window-substring/
 *
 * @author Wu
 * @date 2022年08月18日 12:13
 */
public class Solution {
    static Map<Character, Integer> ori = new HashMap<>();
    static Map<Character, Integer> cnt = new HashMap<>();

    public static String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int cntL = 0;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                if (cnt.getOrDefault(s.charAt(r), 0) < ori.get(s.charAt(r))) {
                    cntL++;
                }
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (cntL == tLen && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    if (cnt.get(s.charAt(l)) <= ori.get(s.charAt(l))) {
                        cntL--;
                    }
                    cnt.put(s.charAt(l), cnt.get(s.charAt(l)) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public static String minWindow2(String s, String t) {
        char[] cs = s.toCharArray(), ct = t.toCharArray();

        // 将字符串t中每个字母出现的次数统计出来，这里--可以理解为有这么多的坑要填
        int[] count = new int[128];
        for (char c : ct) count[c]--;

        String res = "";
        for (int i = 0, j = 0, cnt = 0; i < cs.length; i++) {
            // 利用字符cs[i]去填count数组的坑
            count[cs[i]]++;
            // 如果填完坑之后发现，坑没有满或者刚好满，那么这个填坑是有效的，否则如果坑本来就是满的，这次填坑是无效的
            // 注意其他非t中出现的字符，count数组的值是0，原来坑就是满的，那么填入count数组中，count[cs[i]]肯定大于0
            if (count[cs[i]] <= 0) cnt++;
            // 如果cnt等于ct.length，那么说明窗口内已经包含t了，这时就要考虑移动左指针了，只有当左指针指向的字符是冗余的情况下，即count[cs[j]]>0，才能保证去掉该字符后，窗口中仍然包含t
            // 注意cnt达到字符串t的长度后，它的值就不会再变化了，因为窗口内包含t之后，就会一直包含
            while (cnt == ct.length && count[cs[j]] > 0) {
                count[cs[j]]--;
                j++;
            }
            // 当窗口内包含t后，计算此时窗口内字符串的长度，更新res
            if (cnt == ct.length) {
                if (res.equals("") || res.length() > (i - j + 1))
                    res = s.substring(j, i + 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("bba", "ab"));
    }
}

