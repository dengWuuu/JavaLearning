package LeetCode.周赛总.单周塞.周赛336.题1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
public class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int cnt = 0;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        for (int i = left; i <= right && i < words.length; i++) {
            if (set.contains(words[i].charAt(0)) && set.contains(words[i].charAt(words[i].length() - 1))){
                cnt++;
            }
        }
        return cnt;
    }
}