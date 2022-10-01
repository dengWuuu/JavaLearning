package 剑指Offer_专项突击版.哈希表.有效的变位词;

/**
 * @author Wu
 * @date 2022年10月01日 11:12
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.equals(t)) return false;
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (map[i] != 0) return false;
        }
        return true;
    }
}
