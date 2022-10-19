package 剑指Offer_专项突击版.图.单词演变;

import java.util.*;

/**
 * @author Wu
 * @date 2022年10月19日 18:26
 */
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        int n = beginWord.length();
        int step = 2;
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                char[] arr = queue.poll().toCharArray();
                for (int i = 0; i < n; i++) {
                    char c = arr[i];
                    // 下一个字符串与当前字符串仅差一个字符
                    for (int j = 0; j < 26; j++) {
                        // 若第i个字符与当前字符不同，改变第i个字符
                        if (c - 'a' != j) {
                            arr[i] = (char) (j + 'a');
                            String next = String.valueOf(arr);
                            if (next.equals(endWord)) {
                                return step;
                            }
                            if (set.contains(next)) {
                                queue.offer(next);
                                set.remove(next);
                            }
                        }
                    }
                    arr[i] = c;
                }
            }
            step++;
        }
        return 0;
    }
}