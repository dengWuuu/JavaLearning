package 剑指Offer_专项突击版.图.最长连续序列;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wu
 * @date 2022年10月22日 11:25
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (int j : nums) {
            if (!set.contains(j - 1)) {

                int cur = 1;
                int num = j;
                while (set.contains(num + 1)) {
                    num++;
                    cur++;
                }
                ans = Math.max(ans, cur);
            }
        }
        return ans;
    }
}