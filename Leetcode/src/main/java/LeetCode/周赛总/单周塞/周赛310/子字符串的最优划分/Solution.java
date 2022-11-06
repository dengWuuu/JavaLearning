package LeetCode.周赛总.单周塞.周赛310.子字符串的最优划分;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wu
 * @date 2022年09月11日 10:41
 */
public class Solution {
    int ans = 0;
    Set<Character> set = new HashSet<>();

    public int partitionString(String s) {
        for (int fast = 0, slow = 0; fast < s.length(); fast++) {
            if (set.contains(s.charAt(fast))) {
                set.clear();
                ans++;
            }
            set.add(s.charAt(fast));
        }

        return ans + 1;
    }
}
