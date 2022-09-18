package 代码随想录.贪心.划分字母区间;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年09月17日 9:25
 */
public class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] cache = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cache[s.charAt(i) - 'a'] = i;
        }
        List<Integer> ans = new LinkedList<>();
        int maxRight = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            maxRight = Math.max(cache[s.charAt(i) - 'a'], maxRight);
            if (i == maxRight) {
                ans.add(i - left + 1);
                left = maxRight + 1;
            }
        }
        return ans;
    }
}
