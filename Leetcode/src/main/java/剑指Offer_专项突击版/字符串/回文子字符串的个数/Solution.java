package 剑指Offer_专项突击版.字符串.回文子字符串的个数;

/**
 * @author Wu
 * @date 2022年09月29日 9:31
 */
public class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length()) ans += count(s, i, i) + count(s, i, i + 1);
            else ans += count(s, i, i);
        }
        return ans;
    }

    public int count(String s, int i, int j) {
        int count = 0;
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
                count++;
            } else break;
        }
        return count;
    }
}
