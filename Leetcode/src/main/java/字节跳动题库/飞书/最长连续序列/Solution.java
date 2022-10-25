package 字节跳动题库.飞书.最长连续序列;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wu
 * @date 2022年10月25日 22:03
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;

        for (int k : nums) {
            set.add(k);
        }

        for (int j : nums) {
            set.add(j);
            if (set.contains(j + 1)) {
                continue;
            } else {
                int count = 0;
                int num = j;
                set.add(j);
                while (set.contains(num)) {
                    count++;
                    num--;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}
