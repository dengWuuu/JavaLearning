package LeetCode.热题100.找到字符串中所有字母异位词;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wu
 * @date 2022年09月01日 19:28
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sL = s.length(), pL = p.length();
        if (sL < pL) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int[] hashP = new int[26], hashS = new int[26];
        for (int i = 0; i < p.length(); i++) {
            hashP[p.charAt(i) - 'a']++;
            hashS[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(hashP, hashS)) {
            ans.add(0);
        }
        for (int i = 0; i < sL - pL; i++) {
            ++hashS[s.charAt(i + pL) - 'a'];
            --hashS[s.charAt(i) - 'a'];
            if (Arrays.equals(hashP, hashS)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}

class Solution2 {
    public List<Integer> findAnagrams(String s, String p) {
        int sL = s.length(), pL = p.length();
        if (sL < pL) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int[] count = new int[26];

        for (int i = 0; i < pL; i++) {
            ++count[s.charAt(i) - 'a'];
            --count[p.charAt(i) - 'a'];
        }

        int less = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                less++;
            }
        }
        if (less == 0) ans.add(0);

        for (int i = 0; i < sL - pL; i++) {
            if (count[s.charAt(i) - 'a'] == 1) less--;
            else if (count[s.charAt(i) - 'a'] == 0) less++;
            --count[s.charAt(i) - 'a'];
            if (count[s.charAt(i + pL) - 'a'] == 0) less++;
            else if (count[s.charAt(i + pL) - 'a'] == -1) less--;
            ++count[s.charAt(i + pL) - 'a'];
            if (less == 0) ans.add(i + 1);
        }
        return ans;
    }
}
