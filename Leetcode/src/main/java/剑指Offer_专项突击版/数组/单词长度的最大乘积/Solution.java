package 剑指Offer_专项突击版.数组.单词长度的最大乘积;

/**
 * @author Wu
 * @date 2022年09月26日 19:21
 */
public class Solution {
    public int maxProduct(String[] words) {
        int ans = 0, n = words.length;
        int[] masks = new int[n];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                masks[i] |= 1 << word.charAt(j) - 'a';
            }
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((masks[i] & masks[j]) == 0) ans = Math.max(ans, words[i].length() * words[j].length());
            }
        }

        return ans;
    }
}
