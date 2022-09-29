package 剑指Offer_专项突击版.字符串.字符串中的所有变位词;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年09月28日 17:14
 */
public class Solution {
    public static List<Integer> findAnagrams(String s, String p) {
        int n = s.length(), m = p.length();
        List<Integer> ans = new ArrayList<>();
        if (m > n) return ans;
        int[] arr = new int[26];
        for (int i = 0; i < p.length(); i++) {
            arr[p.charAt(i) - 'a']--;
            arr[s.charAt(i) - 'a']++;
        }
        int diff = 0;
        for (int j : arr) {
            if (j != 0) diff++;
        }
        if (diff == 0) ans.add(0);
        for (int i = p.length(); i < s.length(); i++) {
            int left = s.charAt(i - p.length()) - 'a', right = s.charAt(i) - 'a';
            if (arr[left] == 0) diff++;
            else if (arr[left] == 1) diff--;
            arr[left]--;

            if (arr[right] == 0) diff++;
            else if (arr[right] == -1) diff--;
            arr[right]++;

            if (diff == 0) ans.add(i - p.length() + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}
