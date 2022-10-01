package 剑指Offer_专项突击版.哈希表.外星语言是否排序;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年10月01日 11:18
 */
public class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            String left = words[i];
            String right = words[i + 1];
            int l = 0, r = 0;
            while (l < left.length() && r < right.length()) {
                if (left.charAt(l) == right.charAt(r)) {
                    l++;
                    r++;
                    if (l == left.length() && r == right.length()) break;
                    if (r == right.length()) return false;
                } else {
                    if (map.get(left.charAt(l)) > map.get(right.charAt(r))) return false;
                    else break;
                }
            }
        }
        return true;
    }
}
