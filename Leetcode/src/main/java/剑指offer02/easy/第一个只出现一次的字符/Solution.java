package 剑指offer02.easy.第一个只出现一次的字符;

/**
 * @author Wu
 * @date 2022年08月02日 21:57
 */
public class Solution {
    int[] map;

    public char firstUniqChar(String s) {
        if (s.equals(" ")) return ' ';
        map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i) - 'a'] == 0) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
